package com.blogspot.javabyrajasekhar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@GetMapping("/orderServiceFallback")
	public Mono<String> orderServiceFallback(){
		return Mono.just("orderService is taking too longer to respond is down or please try after some time");
	}
	
	@GetMapping("/paymentServiceFallback")
	public Mono<String> paymentServiceFallback(){
		return Mono.just("paymentServiceFallback is taking too longer to respond is down or please try after some time");
	}
}
