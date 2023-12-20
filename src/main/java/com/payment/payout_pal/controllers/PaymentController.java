package com.payment.payout_pal.controllers;

import com.payment.payout_pal.data.dtos.PaymentRequest;
import com.payment.payout_pal.data.models.Payment;
import com.payment.payout_pal.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/make_payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentRequest request) {
        var response = paymentService.makePayment(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_all_payments")
    public ResponseEntity<?> getPayments() {
        List<Payment> response = paymentService.getPayments();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/get_payment/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable Long id) {
        Payment response = paymentService.getPaymentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    }
