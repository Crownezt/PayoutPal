package com.payment.payout_pal.data.repositories;

import com.payment.payout_pal.data.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
