package com.wherewego.repository;

import com.wherewego.entity.NationInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationInfoRepository extends JpaRepository<NationInfo, Long> {

  boolean existsByContinentName(String continentName);

  boolean existsByNationName(String nationName);

  List<NationInfo> findByContinentNameContains(String continentName);
}
