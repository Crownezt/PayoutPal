package com.payment.payout_pal.data.dtos;

import com.payment.payout_pal.data.models.DeviceType;
import com.payment.payout_pal.data.models.PaymentType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private BigDecimal amount;
    private PaymentType paymentType;
    private DeviceType deviceType;
    private String cardNumber;
    private String recipientAccount;
    private String payerAccount;
}
