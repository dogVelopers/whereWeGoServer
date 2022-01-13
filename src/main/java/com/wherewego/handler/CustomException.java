package com.wherewego.handler;

import com.wherewego.enumType.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

  private final ErrorCode errorCode;
}