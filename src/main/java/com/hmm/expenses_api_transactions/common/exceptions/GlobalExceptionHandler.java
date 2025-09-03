package com.hmm.expenses_api_transactions.common.exceptions;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hmm.expenses_api_transactions.infrastructure.adapter.web.dto.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  private ResponseEntity<ApiResponse<?>> createApiResponseException(Exception exception, int status) {
    log.error("Error occurred:", exception);
    return ResponseEntity
            .status(status)
            .body( ApiResponse.<String>builder()
            .status(status)
            .message("Error occurred: " + exception.getMessage())
            .data(null)
            .build());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<?>> handleGenericException(Exception ex) {
    return createApiResponseException(ex, HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  @ExceptionHandler(DuplicateAccountException.class)
  public ResponseEntity<ApiResponse<?>> handleDuplicateAccountException(Exception ex) {
    return createApiResponseException(ex, HttpStatus.BAD_REQUEST.value());
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ApiResponse<?>> handleBadRequestException(Exception ex) {
    return createApiResponseException(ex, HttpStatus.BAD_REQUEST.value());
  }
}
