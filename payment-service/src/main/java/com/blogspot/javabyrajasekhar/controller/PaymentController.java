package com.blogspot.javabyrajasekhar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.javabyrajasekhar.entity.Payment;
import com.blogspot.javabyrajasekhar.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	private Logger log=LoggerFactory.getLogger(PaymentController.class);
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment ) throws JsonProcessingException{
		log.info("PaymentService request {}", new ObjectMapper().writeValueAsString(payment));
	return	paymentService.savePayment(payment);		
	}
	
	@GetMapping("/{orderId}")
	public Payment findByOrderId(@PathVariable int orderId ) throws JsonProcessingException{
	return	paymentService.findByOrderId(orderId);		
	}
	

}
