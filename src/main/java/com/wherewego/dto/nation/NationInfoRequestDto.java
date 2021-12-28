package com.wherewego.dto.nation;

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
public class NationInfoRequestDto {

  private String continentName;
  private String nationName;
  private String introduce;
  private String quarantinePolicy;
  private String imageUrl;

  @Builder
  public NationInfo toEntity() {
    return NationInfo.builder()
        .continentName(continentName)
        .nationName(nationName)
        .introduce(introduce)
        .quarantinePolicy(quarantinePolicy)
        .imageUrl(imageUrl)
        .build();
  }

}