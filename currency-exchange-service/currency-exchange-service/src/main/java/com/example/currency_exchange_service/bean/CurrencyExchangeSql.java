package com.example.currency_exchange_service.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchangeSql {
    @Id
	private Long id;
    
    @Column(name="currency_from")
	private String from;
    
    @Column(name="currency_to")
	private String to;
	private BigDecimal currencyMultiple;
	private String environment;
	
	public CurrencyExchangeSql() {
		
	}
	
	public CurrencyExchangeSql(Long id, String from, String to, BigDecimal currencyMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyMultiple = currencyMultiple;
	}
	
	
	public String getEnvironment() {
		return environment;
	}


	public void setEnvironment(String environment) {
		this.environment = environment;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getCurrencyMultiple() {
		return currencyMultiple;
	}
	public void setCurrencyMultiple(BigDecimal currencyMultiple) {
		this.currencyMultiple = currencyMultiple;
	}
}

