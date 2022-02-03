package com.wherewego.service.nation;

import com.wherewego.dto.nation.NationInfoRequestDto;
import com.wherewego.dto.nation.NationInfoResponseDto;
import com.wherewego.entity.NationInfo;
import com.wherewego.handler.CustomException;
import com.wherewego.repository.NationInfoRepository;
import com.wherewego.service.image.AwsS3UploadService;
import com.wherewego.service.image.FileUploadService;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static com.wherewego.enumType.ErrorCode.DUPLICATE_RESOURCE;
import static com.wherewego.enumType.ErrorCode.NOT_FOUND_CONTINENT_NAME;
import static com.wherewego.enumType.ErrorCode.NOT_FOUND_IMAGE_FILE;
import static com.wherewego.enumType.ErrorCode.NOT_FOUND_NATION_INFO;

@RequiredArgsConstructor
@Service
public class NationInfoServiceImpl implements NationInfoService {

  private final NationInfoRepository nationInfoRepository;
  private final FileUploadService fileUploadService;
  private final AwsS3UploadService awsS3UploadService;

  @Override
  @Transactional
  public NationInfoResponseDto save(@RequestPart MultipartFile file,
      NationInfoRequestDto nationInfoRequestDto) { //국가정보 저장 메소드

    // 파일이 null일 경우, 에러를 띄워줌.
    if (file.isEmpty()) {
      throw new CustomException(NOT_FOUND_IMAGE_FILE);
    }

    // 이미 등록되어 있는 대륙&국가의 정보를 새로 등록하는 경우, 에러를 띄워줌.
    if (nationInfoRepository.existsByContinentName(nationInfoRequestDto.getContinentName())
        && nationInfoRepository.existsByNationName(
        nationInfoRequestDto.getNationName())) {
      throw new CustomException(DUPLICATE_RESOURCE);
    }

    // DB에 이미지를 저장하면서 동시에 S3에 업로드 하는 코드
    String imgPath = fileUploadService.uploadImage(file);
    nationInfoRequestDto.setImageUrl(imgPath);

    return new NationInfoResponseDto(
        nationInfoRepository.save(nationInfoRequestDto.toEntity()));
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public NationInfoResponseDto update(Long id,
      @RequestPart MultipartFile file,
      NationInfoRequestDto nationInfoRequestDto) { //국가정보 수정 메소드
    NationInfo nationInfo = nationInfoRepository.findById(id)
        .orElseThrow(() -> new CustomException(NOT_FOUND_NATION_INFO));
    nationInfo.setContinentName(nationInfoRequestDto.getContinentName());
    nationInfo.setNationName(nationInfoRequestDto.getNationName());
    nationInfo.setIntroduce(nationInfoRequestDto.getIntroduce());
    nationInfo.setQuarantinePolicy(nationInfoRequestDto.getQuarantinePolicy());

//    // 파일이 null일 경우, 에러를 띄워줌.
//    if (file.isEmpty()) {
//      throw new CustomException(NOT_FOUND_IMAGE_FILE);
//    }

    // 파일이 null일 경우, 기존의 이미지 url을 저장
    if (file.isEmpty()) {
      nationInfo.setImageUrl(nationInfo.getImageUrl());
    }

    // 파일이 null이 아닐 경우, 새로운 이미지 업로드 및 저장
    if (!file.isEmpty()) {
      String imgPath = fileUploadService.uploadImage(file);
      nationInfo.setImageUrl(imgPath);
    }
    nationInfoRepository.save(nationInfo);

    return new NationInfoResponseDto(nationInfo);
  }

  @Override //국가정보 전체 조회 메소드
  @Transactional(rollbackFor = Exception.class)
  public List<NationInfoResponseDto> readAllNationInfo() {

    List<NationInfoResponseDto> nationInfoResponseDtos = new ArrayList<>();
    for (NationInfo nationInfo : nationInfoRepository.findAll()) {
      NationInfoResponseDto nationInfoResponseDto = new NationInfoResponseDto(
          nationInfo);
      nationInfoResponseDtos.add(nationInfoResponseDto);
    }

    return nationInfoResponseDtos;
  }

  @Override //국가정보 낱개 조회 메소드
  @Transactional(rollbackFor = Exception.class)
  public List<NationInfoResponseDto> readNationInfo(Long id) {
    NationInfo nationInfo = nationInfoRepository.findById(id)
        .orElseThrow(() -> new CustomException(NOT_FOUND_NATION_INFO)); // 존재하지 않는 id 값일 경우 에러를 발생시킴
    List<NationInfoResponseDto> nationInfoResponseDtos = new ArrayList<>();

    NationInfoResponseDto nationInfoResponseDto = new NationInfoResponseDto(nationInfo);
    nationInfoResponseDtos.add(nationInfoResponseDto);

    return nationInfoResponseDtos;
  }

  @Override //국가정보 대륙별 조회 메소드
  @Transactional(rollbackFor = Exception.class)
  public List<NationInfoResponseDto> readNationInfoContinentName(String continentName) {

//    // 데이터에 없는 대륙을 조회할 경우 에러를 발생시킴
//    if (nationInfoRepository.findByContinentNameContains(continentName) == null) {
//      throw new CustomException(NOT_FOUND_CONTINENT_NAME);
//    }

    return nationInfoRepository.findByContinentNameContains(continentName)
        .stream()
        .map(NationInfoResponseDto::new)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public HttpStatus delete(Long id) { //국가정보 삭제 메소드
    NationInfo nationInfo = nationInfoRepository.findById(id)
        .orElseThrow(
            () -> new CustomException(NOT_FOUND_NATION_INFO)); // 존재하지 않는 id 값일 경우 에러를 발생시킴

    nationInfoRepository.delete(nationInfo);
    return HttpStatus.OK;
  }
}