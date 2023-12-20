package com.payment.payout_pal.data.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount = BigDecimal.ZERO;
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;
    @Enumerated(value = EnumType.STRING)
    private DeviceType deviceType;
    private String cardNumber;
    private String recipientAccount;
    private String payerAccount;
}
