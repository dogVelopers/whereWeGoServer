package com.wherewego.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "nation_info")
public class NationInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "nation_info_id")
  private Long id;

  @Column
  private String continentName; //대륙명

  @Column
  private String nationName; //나라명

  @Column
  private String introduce; //소개

  @Column
  private String quarantinePolicy; //방역방침

  @Column(columnDefinition = "TEXT")
  private String imageUrl; //이미지URL

  @Builder
  public NationInfo(String continentName, String nationName, String introduce,
      String quarantinePolicy, String imageUrl) {
    this.continentName = continentName;
    this.nationName = nationName;
    this.introduce = introduce;
    this.quarantinePolicy = quarantinePolicy;
    this.imageUrl = imageUrl;
  }

}
