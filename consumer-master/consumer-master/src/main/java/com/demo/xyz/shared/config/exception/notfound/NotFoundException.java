package com.demo.xyz.shared.config.exception.notfound;

import com.demo.xyz.shared.config.exception.BaseException;
import com.demo.xyz.shared.config.exception.ExceptionCode;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

  protected NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message, ExceptionCode.NOT_FOUND);
  }
}
