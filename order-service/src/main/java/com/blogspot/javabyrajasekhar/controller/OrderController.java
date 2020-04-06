package com.blogspot.javabyrajasekhar.controller;

import java.util.List;

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

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrders")
	public TransactionResponse bookOrders(@RequestBody TransactionRequest request){		
		return orderService.bookOrder(request);
	}

	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders(){		
		return orderService.getAllOrders();
		
	}

}
