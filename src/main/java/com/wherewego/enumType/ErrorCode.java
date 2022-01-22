package com.wherewego.enumType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
  NOT_FOUND_NATION_INFO(NOT_FOUND, "해당 국가 정보를 찾을 수 없습니다."),
  NOT_FOUND_IMAGE_FILE(NOT_FOUND, "이미지 파일을 찾을 수 없습니다."),

  /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
  DUPLICATE_RESOURCE(CONFLICT, "해당 국가 정보가 이미 존재합니다.");

  /* 500 INTERNAL_SERVER_ERROR : 문제의 구체적인 내용을 표시할 수 없음 */


  private final HttpStatus httpStatus;
  private final String detail;
}