package com.example.currency_exchange_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.currency_exchange_service.bean.CurrencyExchangeSql;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeSql, Long>{
     CurrencyExchangeSql findByFromAndTo(String from, String to);
}
