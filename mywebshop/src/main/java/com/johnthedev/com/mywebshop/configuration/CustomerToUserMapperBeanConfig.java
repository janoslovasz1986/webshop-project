package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.johnthedev.com.mywebshop.mapper.CustomerToUserMapper;

@Configuration
public class CustomerToUserMapperBeanConfig {

	@Bean
	//@SessionScope
	@Scope("prototype")
	public CustomerToUserMapper ustomerToUserMapper() {

		return new CustomerToUserMapper();

	}

}
