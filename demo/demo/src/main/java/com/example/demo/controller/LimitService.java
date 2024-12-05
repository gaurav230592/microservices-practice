package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Limit;
import com.example.demo.configurations.Configuration;

@RestController
public class LimitService {

	@Autowired
	Configuration configuration;
	
	@GetMapping("/limit")
	public Limit retriveLimits() {
		//return new Limit(1, 1000);
		return new Limit(configuration.getMin(), configuration.getMax());
	}
}
