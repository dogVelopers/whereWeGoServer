package com.wherewego.service;

import com.wherewego.dto.NationInfoDto;
import com.wherewego.repository.NationInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageSaveService {

  private NationInfoRepository nationInfoRepository;

  public void savePost(NationInfoDto nationInfoDto) { //DB에 이미지를 저장하는 메소드
    nationInfoRepository.save(nationInfoDto.toEntity());
  }

}
