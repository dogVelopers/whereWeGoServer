package com.wherewego.controller;

import com.wherewego.dto.nation.NationInfoRequestDto;
import com.wherewego.dto.nation.NationInfoResponseDto;
import com.wherewego.service.nation.NationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NationInfoController {

  private final NationInfoService nationInfoService;

  @PostMapping("/nation-info") //국가정보 저장
  public ResponseEntity<NationInfoResponseDto> save(
      @RequestPart(value = "file", required = false) MultipartFile file,
      @RequestPart(value = "nationInfoRequestDto") NationInfoRequestDto nationInfoRequestDto) {
    return ResponseEntity.ok(nationInfoService.save(file, nationInfoRequestDto));
  }

  @PatchMapping("/nation-info/{id}") //국가정보 수정
  public ResponseEntity<NationInfoResponseDto> update(@PathVariable Long id,
      @RequestPart(value = "file", required = false) MultipartFile file,
      @RequestPart(value = "nationInfoRequestDto") NationInfoRequestDto nationInfoRequestDto) {
    return ResponseEntity.ok(nationInfoService.update(id, file, nationInfoRequestDto));
  }

  @DeleteMapping("/nation-info/{id}") //국가정보 삭제
  public ResponseEntity delete(@PathVariable Long id) {
    return new ResponseEntity(nationInfoService.delete(id));
  }

}
