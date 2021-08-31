package com.johnthedev.com.mywebshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.johnthedev.com.mywebshop.service.storage.StorageProperties;
import com.johnthedev.com.mywebshop.service.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MywebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywebshopApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
