package com.springcloud.exchangeconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="exchange-service")
public interface ExchangeConversionIF {

	@GetMapping("/exchange-currency/from/{from}/to/{to}")
	public ExchangeConversionEntity retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to);
}
