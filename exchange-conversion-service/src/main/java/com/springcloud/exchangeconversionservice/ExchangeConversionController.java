package com.springcloud.exchangeconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
public class ExchangeConversionController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ExchangeConversionIF convIF;
	
	@GetMapping("/exchange-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeConversionEntity calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		
		ResponseEntity<ExchangeConversionEntity> responseEntity = restTemplate.getForEntity
		("http://localhost:8000/exchange-currency/from/{from}/to/{to}", 
				ExchangeConversionEntity.class, uriVariables);
		
		ExchangeConversionEntity currencyConversion = responseEntity.getBody();
		
		return new ExchangeConversionEntity(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment()+ " " + "rest template");
		
	}
	
	@GetMapping("/exchange-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeConversionEntity calculateCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		
		ExchangeConversionEntity currencyConversion = convIF.retrieveExchangeValue(from, to);
		
		return new ExchangeConversionEntity(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment()+ " " + "feign template");
		
	}
}
