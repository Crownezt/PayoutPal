package com.payment.payout_pal.services;

import com.payment.payout_pal.data.dtos.PaymentRequest;
import com.payment.payout_pal.data.models.Account;
import com.payment.payout_pal.data.models.Payment;
import com.payment.payout_pal.data.repositories.PaymentRepository;
import com.payment.payout_pal.exceptions.PaymentException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final AccountService accountService;
    @Override
    public Payment makePayment(PaymentRequest request) {
        Payment payment = addPayment(request);
        return paymentRepository.save(payment);
    }

    private Payment addPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setPaymentType(request.getPaymentType());
        payment.setDeviceType(request.getDeviceType());
        payment.setCardNumber(request.getCardNumber());
        accountService.debitAccount(request.getPayerAccount(), request.getAmount());
        accountService.creditAccount(request.getRecipientAccount(), request.getAmount());
        payment.setPayerAccount(request.getPayerAccount());
        payment.setRecipientAccount(request.getRecipientAccount());
        return payment;
    }

    @Override
    public List<Payment> getPayments() {
        List<Payment> foundPayments = paymentRepository.findAll();
        return foundPayments;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment foundPayment = paymentRepository.findById(id).orElseThrow(()->
                new PaymentException("Payment with id %d is not found ", id));
        return foundPayment;
    }


}
