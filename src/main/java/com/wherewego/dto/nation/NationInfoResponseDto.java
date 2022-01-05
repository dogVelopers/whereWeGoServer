package com.wherewego.dto.nation;

import com.wherewego.entity.NationInfo;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class NationInfoResponseDto {

  private Long id;
  private String continentName;
  private String nationName;
  private String introduce;
  private String quarantinePolicy;
  private String imageUrl;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;

  public NationInfoResponseDto(NationInfo nationInfo) {
    this.id = nationInfo.getId();
    this.continentName = nationInfo.getContinentName();
    this.nationName = nationInfo.getNationName();
    this.introduce = nationInfo.getIntroduce();
    this.quarantinePolicy = nationInfo.getQuarantinePolicy();
    this.imageUrl = nationInfo.getImageUrl();
    this.createdDate = nationInfo.getCreatedDate();
    this.modifiedDate = nationInfo.getModifiedDate();
  }
}
