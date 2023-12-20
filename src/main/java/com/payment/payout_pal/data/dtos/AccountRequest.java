package com.payment.payout_pal.data.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequest {
    private Long id;
    private String accountName;
    private String accountNumber;
    private BigDecimal amount;
}
