package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.johnthedev.com.mywebshop.mapper.OrderDtoMapper;

@Configuration
public class OrderDtoMapperBeanConfig {

	@Bean
	//@SessionScope
	@Scope("prototype")
	public OrderDtoMapper orderDtoMapper() {

		return new OrderDtoMapper();

	}

}
