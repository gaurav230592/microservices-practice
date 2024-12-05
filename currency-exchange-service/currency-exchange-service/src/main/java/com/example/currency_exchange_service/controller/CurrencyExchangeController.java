package com.example.currency_exchange_service.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currency_exchange_service.bean.CurrencyExchange;
import com.example.currency_exchange_service.bean.CurrencyExchangeSql;
import com.example.currency_exchange_service.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	CurrencyExchangeRepository cer;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/currencyexchange/from/{from}/to/{to}")
	public CurrencyExchangeSql retrivalCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		String port = environment.getProperty("local.server.port");
		
		CurrencyExchange currencyExchange =  new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		
		CurrencyExchangeSql ceByDatabase = cer.findByFromAndTo(from, to);
		ceByDatabase.setEnvironment(port);
		return ceByDatabase;
		
	}
}
