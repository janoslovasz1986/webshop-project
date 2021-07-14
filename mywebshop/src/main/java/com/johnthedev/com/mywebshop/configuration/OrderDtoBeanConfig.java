package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.johnthedev.com.mywebshop.dto.OrderDto;

@Configuration
public class OrderDtoBeanConfig {


	@Bean
	//@RequestScope
	@Scope("prototype")
	public OrderDto orderDto() {
		
		return new OrderDto();
		
	}
}
