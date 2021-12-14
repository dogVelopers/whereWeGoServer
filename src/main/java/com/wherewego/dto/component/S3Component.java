package com.wherewego.dto.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "cloud.aws.s3") //이를 통해서 properties에서 bucket의 값을 받도록 구성
@Component
public class S3Component {

  private String bucket;

}