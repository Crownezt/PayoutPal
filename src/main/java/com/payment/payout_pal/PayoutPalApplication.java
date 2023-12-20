package com.payment.payout_pal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.payment.payout_pal.services", "com.payment.payout_pal.controllers"})
public class PayoutPalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayoutPalApplication.class, args);
	}

}
