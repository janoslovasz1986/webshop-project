package com.johnthedev.com.mywebshop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.johnthedev.com.mywebshop.service.email.EmailService;

@Configuration
public class EmailServiceBeanConfig {
	
	@Bean
	public EmailService theEmailService() {
		
		return new EmailService();
	}
	

}
