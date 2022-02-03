package com.wherewego.service.nation;

import com.wherewego.dto.nation.NationInfoRequestDto;
import com.wherewego.dto.nation.NationInfoResponseDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface NationInfoService {

  NationInfoResponseDto save(@RequestPart MultipartFile file,
      NationInfoRequestDto nationInfoRequestDto);

  NationInfoResponseDto update(Long id, @RequestPart MultipartFile file,
      NationInfoRequestDto nationInfoRequestDto);

  List<NationInfoResponseDto> readAllNationInfo();

  List<NationInfoResponseDto> readNationInfo(Long id);

  List<NationInfoResponseDto> readNationInfoContinentName(String continentName);

  HttpStatus delete(Long id);

}
