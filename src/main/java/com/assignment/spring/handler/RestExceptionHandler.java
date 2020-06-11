package com.assignment.spring.handler;

import com.assignment.spring.model.ApiError;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(FeignException.class)
  protected ResponseEntity<Object> handleFeignException(FeignException ex) {
    ApiError apiError = new ApiError(HttpStatus.valueOf(ex.status()));
    apiError.setMessage(ex.getMessage());
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
