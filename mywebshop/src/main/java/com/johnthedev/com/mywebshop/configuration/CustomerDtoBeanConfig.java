package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.johnthedev.com.mywebshop.dto.CustomerDto;

@Configuration
public class CustomerDtoBeanConfig {


	@Bean
	//@RequestScope
	@Scope("prototype")
	public CustomerDto customerDto() {
		
		return new CustomerDto();
		
	}
}
