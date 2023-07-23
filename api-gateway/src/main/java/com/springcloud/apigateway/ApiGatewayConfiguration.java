package com.springcloud.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				
				.route(p -> p.path("/exchange-service/**")
						.uri("lb://exchange-service"))
				.route(p -> p.path("/exchange-conversion/**")
						.uri("lb://exchange-conversion"))
				.route(p -> p.path("/exchange-conversion-feign/**")
						.uri("lb://exchange-conversion"))
				.route(p -> p.path("/exchange-conversion-new/**")
						.filters(f -> f.rewritePath(
								"/exchange-conversion-new/(?<segment>.*)", 
								"/exchange-conversion-feign/${segment}"))
						.uri("lb://exchange-conversion"))
				.build();
	}
}
