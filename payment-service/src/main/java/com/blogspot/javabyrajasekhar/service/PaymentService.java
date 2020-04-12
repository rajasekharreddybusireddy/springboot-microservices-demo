package com.blogspot.javabyrajasekhar.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogspot.javabyrajasekhar.entity.Payment;
import com.blogspot.javabyrajasekhar.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	private Logger log=LoggerFactory.getLogger(PaymentService.class);
	
	public Payment savePayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentProcessing());
		return paymentRepository.save(payment)	;
	}

	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}

	public Payment findByOrderId(int orderId) throws JsonProcessingException {
		Payment payment = paymentRepository.findByOrderId(orderId);
		log.info("PaymentService response {}  ", new ObjectMapper().writeValueAsString(payment));
		return payment;
	}
	

}
