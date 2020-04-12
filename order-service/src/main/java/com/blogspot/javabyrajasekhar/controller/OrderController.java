package com.blogspot.javabyrajasekhar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.javabyrajasekhar.common.TransactionRequest;
import com.blogspot.javabyrajasekhar.common.TransactionResponse;
import com.blogspot.javabyrajasekhar.entity.Order;
import com.blogspot.javabyrajasekhar.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	private Logger log=LoggerFactory.getLogger(OrderController.class);
	
	@PostMapping("/bookOrders")
	public TransactionResponse bookOrders(@RequestBody TransactionRequest request) throws JsonProcessingException{	
		log.info("OrderService request bookOrders{} ", new ObjectMapper().writeValueAsString(request));
		return orderService.bookOrder(request);
	}

	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders() throws JsonProcessingException{	
		log.info("OrderService getAllOrders {}", new ObjectMapper().writeValueAsString(orderService.getAllOrders()));
		return orderService.getAllOrders();
		
	}

}
