package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.SessionScope;

import com.johnthedev.com.mywebshop.mapper.ProductDtoMapper;

@Configuration
public class ProductDtoMapperBeanConfig {

	@Bean
	//@SessionScope
	@Scope("prototype")
	public ProductDtoMapper productDtoMapper() {

		return new ProductDtoMapper();

	}

}
