package com.wherewego.dto;

import com.wherewego.entity.Continent;
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

  private Continent continent;
  private String nationName;
  private String introduce;
  private String quarantinePolicy;
  private String imageUrl;

  public NationInfo toEntity() {
    NationInfo nationInfo = NationInfo.builder()
        .continent(continent)
        .nationName(nationName)
        .introduce(introduce)
        .quarantinePolicy(quarantinePolicy)
        .imageUrl(imageUrl)
        .build();
    return nationInfo;
  }

  @Builder
  public NationInfoDto(Continent continent, String nationName, String introduce,
      String quarantinePolicy, String imageUrl) {
    this.continent = continent;
    this.nationName = nationName;
    this.introduce = introduce;
    this.quarantinePolicy = quarantinePolicy;
    this.imageUrl = imageUrl;
  }

}
