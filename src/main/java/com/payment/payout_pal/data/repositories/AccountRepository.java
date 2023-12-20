package com.payment.payout_pal.data.repositories;

import com.payment.payout_pal.data.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByAccountNumber(String accountNumber);

}
