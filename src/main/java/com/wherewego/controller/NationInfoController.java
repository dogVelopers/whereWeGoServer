package com.wherewego.controller;

import com.wherewego.dto.nation.NationInfoRequestDto;
import com.wherewego.dto.nation.NationInfoResponseDto;
import com.wherewego.service.nation.NationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class NationInfoController {

  private final NationInfoService nationInfoService;

  @PostMapping("/nation-infos") //국가정보 저장
  public ResponseEntity<NationInfoResponseDto> save(
      @RequestPart(value = "file", required = false) MultipartFile file,
      @RequestPart(value = "nationInfoRequestDto") NationInfoRequestDto nationInfoRequestDto) {
    return ResponseEntity.ok(nationInfoService.save(file, nationInfoRequestDto));
  }

  @PostMapping("/nation-infos/{id}") //국가정보 수정
  public ResponseEntity<NationInfoResponseDto> update(@PathVariable Long id,
      @RequestPart(value = "file", required = false) MultipartFile file,
      @RequestPart(value = "nationInfoRequestDto") NationInfoRequestDto nationInfoRequestDto) {
    return ResponseEntity.ok(nationInfoService.update(id, file, nationInfoRequestDto));
  }

  @GetMapping("/nation-infos") //국가정보 전체 조회
  public ResponseEntity<NationInfoResponseDto> readAllNationInfo() {
    return new ResponseEntity(nationInfoService.readAllNationInfo(),
        HttpStatus.OK);
  }

  @GetMapping("/nation-infos/{id}") //국가정보 낱개 조회
  public ResponseEntity<NationInfoResponseDto> readNationInfo(@PathVariable Long id) {
    return new ResponseEntity(nationInfoService.readNationInfo(id),
        HttpStatus.OK);
  }

  @DeleteMapping("/nation-infos/{id}") //국가정보 삭제
  public ResponseEntity delete(@PathVariable Long id) {
    return new ResponseEntity(nationInfoService.delete(id));
  }

}
