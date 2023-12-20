package com.payment.payout_pal.services;

import com.payment.payout_pal.data.dtos.PaymentRequest;
import com.payment.payout_pal.data.models.Payment;

import java.util.List;


public interface PaymentService{

    Payment makePayment(PaymentRequest request);
    List<Payment> getPayments();
    Payment getPaymentById(Long id);
}
