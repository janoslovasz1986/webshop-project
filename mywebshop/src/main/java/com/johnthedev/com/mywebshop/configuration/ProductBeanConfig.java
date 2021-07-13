package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

import com.johnthedev.com.mywebshop.entity.Product;

@Configuration
public class ProductBeanConfig {
		
		@Bean
		//@RequestScope
		@Scope("prototype")
		public Product product() {
			
			return new Product();
		}
		
	}


