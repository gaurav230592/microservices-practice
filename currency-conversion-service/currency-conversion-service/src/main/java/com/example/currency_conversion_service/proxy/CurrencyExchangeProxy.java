package com.example.currency_conversion_service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currency_conversion_service.controller.CurrencyConvertion;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")

// if you are working with feign + eureka + loadbalancer together
// remove url from @FeignClient
// feign client uses load balancer to check instances in naming server and distributes traffic to multiple instances of microservice A
// load balancer dependency by default present in netflix-eureka-client
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currencyexchange/from/{from}/to/{to}")
	public CurrencyConvertion retrivalCurrencyExchange(@PathVariable String from, @PathVariable String to);
}
