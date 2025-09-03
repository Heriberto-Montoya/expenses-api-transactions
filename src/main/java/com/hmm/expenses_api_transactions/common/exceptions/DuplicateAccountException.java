package com.hmm.expenses_api_transactions.common.exceptions;

public class DuplicateAccountException extends Exception {
  public DuplicateAccountException(String message){
    super(message);
  }
}
