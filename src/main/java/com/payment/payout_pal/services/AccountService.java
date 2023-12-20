package com.payment.payout_pal.services;

import com.payment.payout_pal.data.models.Account;

import java.math.BigDecimal;
import java.util.List;


public interface AccountService {


    Account createAccount(String accountName);

    Account creditAccount(String accountNumber, BigDecimal amount);
    Account debitAccount(String accountNumber, BigDecimal amount);

    List<Account> getAccounts();
}
