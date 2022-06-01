package com.nttdata.bank.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("service-customer", 
						r -> r.path("/api/customer/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-customer"))
				.route("service-account", 
						r -> r.path("/api/account/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-account"))
				.route("service-person", 
						r -> r.path("/api/person/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-person"))
				/*Descomentar para probar*/
//				.route("service-transaction", 
//						r -> r.path("/api/transaction/**")
//						.filters(f -> f.circuitBreaker(c -> c.setName("defaultCircuit")
//										.addStatusCode("500")
//										.setFallbackUri("forward:http://localhost:9950/fallback"))
//								.stripPrefix(2))
//						.uri("lb://service-transaction"))
				.route("service-transaction", 
						r -> r.path("/api/transaction/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-transaction"))
				.route("service-product", 
						r -> r.path("/api/product/**")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://service-product"))
				.build();
	}

}
