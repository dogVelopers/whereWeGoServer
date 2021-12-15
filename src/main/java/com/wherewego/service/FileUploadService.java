package com.wherewego.service;

import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileUploadService {

  private final UploadService s3Service;

  public String uploadImage(MultipartFile file) {
    String fileName = createFileName(file.getOriginalFilename());
    ObjectMetadata objectMetadata = new ObjectMetadata();
    objectMetadata.setContentType(file.getContentType());
    objectMetadata.setContentLength(file.getSize());
    try (InputStream inputStream = file.getInputStream()) { //입력 받은 파일에서 파일의 기존 이름, metadata, inputStream을 읽어오고 이를 토대로 S3에 저장을 요청함
      s3Service.uploadFile(inputStream, objectMetadata, fileName);
    } catch (IOException e) {
      throw new IllegalArgumentException(
          String.format("파일 변환 중 에러가 발생하였습니다 (%s)", file.getOriginalFilename()));
    }
    return s3Service.getFileUrl(fileName);
  }

  private String createFileName(String originalFileName) {
    return UUID.randomUUID().toString().concat(getFileExtension(originalFileName)); //기존의 파일명을 통해서 랜덤으로 숫자와 영어로 구성된 이름을 만들어 저장함
  }

  private String getFileExtension(String fileName) {
    try {
      return fileName.substring(fileName.lastIndexOf("."));
    } catch (StringIndexOutOfBoundsException e) {
      throw new IllegalArgumentException(String.format("잘못된 형식의 파일 (%s) 입니다", fileName));
    }
  }

}