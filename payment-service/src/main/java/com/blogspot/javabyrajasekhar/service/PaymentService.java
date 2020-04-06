package com.blogspot.javabyrajasekhar.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogspot.javabyrajasekhar.entity.Payment;
import com.blogspot.javabyrajasekhar.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment savePayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentProcessing());
		return paymentRepository.save(payment)	;
	}

	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}

	public Payment findByOrderId(int orderId) {
		return paymentRepository.findByOrderId(orderId);
	}
	

}
