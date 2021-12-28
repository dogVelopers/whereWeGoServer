package com.wherewego.service.nation;

import com.wherewego.dto.nation.NationInfoRequestDto;
import com.wherewego.dto.nation.NationInfoResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface NationInfoService {

  NationInfoResponseDto save(@RequestPart MultipartFile file,
      NationInfoRequestDto nationInfoRequestDto);

  NationInfoResponseDto update(Long id, @RequestPart MultipartFile file,
      NationInfoRequestDto nationInfoRequestDto);

  HttpStatus delete(Long id);

}
