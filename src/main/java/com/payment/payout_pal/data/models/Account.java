package com.payment.payout_pal.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountName;
    private String accountNumber;
    private BigDecimal balance = BigDecimal.ZERO;
}
