package com.example.currency_exchange_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-apii")
	public String viewBoard() {
		return "Sample API";
	}
	
	@GetMapping("/sample-api")
//	@Retry(name="sample-api")
	//@Retry(name="sample-api", fallbackMethod="hardcodedResponse")
	@CircuitBreaker(name="sample-api", fallbackMethod="hardcodedResponse")
	public String viewBoardi() {
		logger.info("sample-api");
		ResponseEntity<String> rs = new RestTemplate().getForEntity("http://localhost:8080/sample-api", String.class);
		return rs.getBody();
	}
	
	public String hardcodedResponse(Exception ex) {
		return "Hard Coded Response";
	}
}
