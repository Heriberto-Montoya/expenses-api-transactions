package com.hmm.expenses_api_transactions.common.exceptions;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(String message){
        super(message);
    }
}
