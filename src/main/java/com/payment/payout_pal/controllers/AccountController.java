package com.payment.payout_pal.controllers;

import com.payment.payout_pal.data.models.Account;
import com.payment.payout_pal.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create_account")
    public ResponseEntity<?> createAccount(@RequestParam String accountName) {
        var response = accountService.createAccount(accountName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }

    @PostMapping("/credit_account")
    public String creditAccount(@RequestParam String accountNumber, BigDecimal amount) {
        accountService.creditAccount(accountNumber, amount);
        return "Successfully debited";

    }

    @PostMapping("/debit_account")
    public String debitAccount(@RequestParam String accountNumber, BigDecimal amount) {
        accountService.debitAccount(accountNumber, amount);
        return "Successfully debited";
    }

    @GetMapping("/get_all_accounts")
    public ResponseEntity<?> getAccounts() {
        var response = accountService.getAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
