package com.wherewego.dto.nation;

import com.wherewego.entity.NationInfo;
import lombok.Getter;

@Getter
public class NationInfoResponseDto {

  private Long id;
  private String continentName;
  private String nationName;
  private String introduce;
  private String quarantinePolicy;
  private String imageUrl;

  public NationInfoResponseDto(NationInfo nationInfo) {
    this.id = nationInfo.getId();
    this.continentName = nationInfo.getContinentName();
    this.nationName = nationInfo.getNationName();
    this.introduce = nationInfo.getIntroduce();
    this.quarantinePolicy = nationInfo.getQuarantinePolicy();
    this.imageUrl = nationInfo.getImageUrl();
  }
}
