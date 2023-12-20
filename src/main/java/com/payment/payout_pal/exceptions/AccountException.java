package com.payment.payout_pal.exceptions;

public class AccountException extends RuntimeException{

    public AccountException(String message){
        super(message);
    }
}
