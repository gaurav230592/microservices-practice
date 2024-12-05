package com.example.currency_conversion_service.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.currency_conversion_service.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		HashMap<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("from", from);
		urlVariables.put("to", to);
		ResponseEntity<CurrencyConvertion> currencyConversionResponse = new RestTemplate().getForEntity("http://localhost:8000/currencyexchange/from/{from}/to/{to}", CurrencyConvertion.class, urlVariables);
		CurrencyConvertion currencyConversion = currencyConversionResponse.getBody();
		
		return new CurrencyConvertion(currencyConversion.getId(), from, to, quantity, currencyConversion.getCurrencyMultiple(), quantity.multiply(currencyConversion.getCurrencyMultiple()), currencyConversion.getEnvironment());
		
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConvertion currencyConvertionProxy = proxy.retrivalCurrencyExchange(from, to);
		
		return new CurrencyConvertion(currencyConvertionProxy.getId(), from, to, quantity, currencyConvertionProxy.getCurrencyMultiple(), quantity.multiply(currencyConvertionProxy.getCurrencyMultiple()), currencyConvertionProxy.getEnvironment()+"=feign");
		
	}
}
