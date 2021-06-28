package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.johnthedev.com.mywebshop.entity.ShoppingCartItem;

@Configuration
public class ShoppingCartBeanConfig {
	/*
	@Bean
	@SessionScope
	public ShoppingCartItem shoppingCartItem() {
		
		return new ShoppingCartItem();
	}
	*/
}
