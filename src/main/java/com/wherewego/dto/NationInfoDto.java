package com.wherewego.dto;

import com.wherewego.entity.NationInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NationInfoDto {

  private String continentName;
  private String nationName;
  private String introduce;
  private String quarantinePolicy;
  private String imageUrl;

  public NationInfo toEntity() {
    NationInfo nationInfo = NationInfo.builder()
        .continentName(continentName)
        .nationName(nationName)
        .introduce(introduce)
        .quarantinePolicy(quarantinePolicy)
        .imageUrl(imageUrl)
        .build();
    return nationInfo;
  }

  @Builder
  public NationInfoDto(String continentName, String nationName, String introduce,
      String quarantinePolicy, String imageUrl) {
    this.continentName = continentName;
    this.nationName = nationName;
    this.introduce = introduce;
    this.quarantinePolicy = quarantinePolicy;
    this.imageUrl = imageUrl;
  }

}
