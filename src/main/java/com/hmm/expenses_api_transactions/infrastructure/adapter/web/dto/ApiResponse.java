package com.hmm.expenses_api_transactions.infrastructure.adapter.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
  public Integer status;
  public String message;
  public T data;

}