package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.johnthedev.com.mywebshop.entity.Order;

@Configuration
public class OrderBeanConfig {
		
		@Bean
		//@RequestScope
		@Scope("prototype")
		public Order order() {
			
			return new Order();
		}
		
	}


