//package com.wherewego.entity;
//
//import com.wherewego.enumtype.ContinentName;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Table(name = "continent")
//public class Continent {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "continent_id")
//  private Long id;
//
//  @Column
//  @Enumerated(EnumType.STRING)
//  private ContinentName continentName; //대륙명
//
//  @Builder
//  public Continent(ContinentName continentName) {
//    this.continentName = continentName;
//  }
//}
