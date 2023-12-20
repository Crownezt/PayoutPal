package com.payment.payout_pal.exceptions;

public class PaymentException extends RuntimeException {

    public PaymentException(String message, Long id) {
        super(message);
    }

}
