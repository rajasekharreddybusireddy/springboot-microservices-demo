package com.blogspot.javabyrajasekhar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.javabyrajasekhar.entity.Payment;
import com.blogspot.javabyrajasekhar.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment ){
	return	paymentService.savePayment(payment);		
	}
	
	@GetMapping("/{orderId}")
	public Payment findByOrderId(@PathVariable int orderId ){
	return	paymentService.findByOrderId(orderId);		
	}
	

}
