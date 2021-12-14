package com.wherewego.controller;

import com.wherewego.dto.NationInfoDto;
import com.wherewego.service.FileUploadService;
import com.wherewego.service.ImageSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class FileUploadController {

  private final FileUploadService fileUploadService;
  private final ImageSaveService imageSaveService;

  @PostMapping("/save") //S3 bucket에 image 업로드 하면서 DB에 imageUrl 저장
  public String saveImage(@RequestPart MultipartFile file, NationInfoDto nationInfoDto) {
    String imgPath = fileUploadService.uploadImage(file);
    nationInfoDto.setImageUrl(imgPath);

    imageSaveService.savePost(nationInfoDto);

    return fileUploadService.uploadImage(file);
  }

}