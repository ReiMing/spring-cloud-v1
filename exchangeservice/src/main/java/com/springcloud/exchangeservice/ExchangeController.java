package com.springcloud.exchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExchangeController {

	private Logger logger = LoggerFactory.getLogger(ExchangeController.class);
	
	@Autowired
	private ExchangeCurrencyRepository repo;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping("/exchange-currency/from/{from}/to/{to}")
	public ExchangeEntity getCurrency(@PathVariable String from, @PathVariable String to) throws Exception {
		
		logger.info("getCurrency called with {} to {}", from, to);
		
		ExchangeEntity entity = repo.findByFromAndTo(from, to);
		
		if(entity == null) {
			throw new Exception("Unable to Find data for " + from + " to " + to);
		}
		
		logger.info("find"+ entity.getId());
		
		entity.setEnvironment(environment.getProperty("local.server.port"));
		return entity;
	}
}
