package com.payment.payout_pal.services;

import com.payment.payout_pal.data.models.Account;
import com.payment.payout_pal.data.repositories.AccountRepository;
import com.payment.payout_pal.exceptions.AccountException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(String accountName) {
        Account account = new Account();
        account.setAccountName(accountName);
        account.setAccountNumber(generateAccountNumber());
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    private String generateAccountNumber() {
        SecureRandom random = new SecureRandom();
        long randNum = Math.abs(random.nextLong() % 100000000L);
        return "21" + java.lang.String.format("%08d", randNum);
    }

    @Override
    @Transactional
    public Account creditAccount(String accountNumber, BigDecimal amount) {
        Account foundAccount = accountRepository.findAccountByAccountNumber(accountNumber);
        if (foundAccount == null) {
            throw new AccountException("Account does not exist");
        }
        foundAccount.setBalance(foundAccount.getBalance().add(amount));
        return accountRepository.save(foundAccount);
    }

    @Override
    @Transactional
    public Account debitAccount(String accountNumber, BigDecimal amount) {
        Account foundAccount = accountRepository.findAccountByAccountNumber(accountNumber);
        if (foundAccount == null) throw new AccountException("Account does not exist");
        int result = foundAccount.getBalance().compareTo(amount);
        if (result < 0) throw new AccountException("Insufficient fund");
        foundAccount.setBalance(foundAccount.getBalance().subtract(amount));
        return accountRepository.save(foundAccount);
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> foundAccounts = accountRepository.findAll();
        return foundAccounts;
    }
}
