package com.wherewego.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.wherewego.dto.component.S3Component;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.io.InputStream;

@RequiredArgsConstructor
@Component
public class AwsS3UploadService implements UploadService {

  private final AmazonS3 amazonS3;
  private final S3Component component;

  @Override
  public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) { //파일을 업로드 하는 메소드
    amazonS3.putObject(new PutObjectRequest(component.getBucket(), fileName, inputStream, objectMetadata)
        .withCannedAcl(CannedAccessControlList.PublicRead));
  }

  @Override
  public String getFileUrl(String fileName) { //업로드한 파일의 URI를 가져오는 메소드
    return amazonS3.getUrl(component.getBucket(), fileName).toString();
  }

}