package com.blogspot.javabyrajasekhar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blogspot.javabyrajasekhar.common.Payment;
import com.blogspot.javabyrajasekhar.common.TransactionRequest;
import com.blogspot.javabyrajasekhar.common.TransactionResponse;
import com.blogspot.javabyrajasekhar.entity.Order;
import com.blogspot.javabyrajasekhar.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private OrderRepository orderRepository;
	
	public TransactionResponse bookOrder(TransactionRequest request) {
		Order order = request.getOrder();
		Order order2 = orderRepository.save(order);
		Payment payment = request.getPayment();
		payment.setAmount(order.getPrice());
		payment.setOrderId(order2.getOrderId());
		Payment payment2 = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		String message=payment2.getPaymentStatus().equals("success")?"payment processing successful and order placed":"payment got failed and order saved to cart ";
		return new TransactionResponse(order2,payment2.getTransactionId(),payment2.getAmount(),message);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
}
