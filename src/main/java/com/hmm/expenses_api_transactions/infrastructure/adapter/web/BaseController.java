package com.hmm.expenses_api_transactions.infrastructure.adapter.web;

import com.hmm.expenses_api_transactions.infrastructure.adapter.web.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.time.Duration;

public class BaseController {
  protected <T> ResponseEntity<ApiResponse<T>> createResponse(T data, Integer status, String message){
    ApiResponse<T> dataResponse = ApiResponse.<T>builder()
    .data(data)
    .message(message)
    .status(status)
    .build();

    return  ResponseEntity.ok(dataResponse);
  }
}
