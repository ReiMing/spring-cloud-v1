package com.springcloud.exchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeCurrencyRepository extends JpaRepository<ExchangeEntity,Integer>{

	ExchangeEntity findByFromAndTo(String from, String to);
}
