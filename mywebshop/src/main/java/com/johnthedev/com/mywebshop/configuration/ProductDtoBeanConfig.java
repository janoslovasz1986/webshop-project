package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

import com.johnthedev.com.mywebshop.dto.ProductDto;

@Configuration
public class ProductDtoBeanConfig {


	@Bean
	//@RequestScope
	@Scope("prototype")
	public ProductDto productDto() {
		
		return new ProductDto();
		
	}
}
