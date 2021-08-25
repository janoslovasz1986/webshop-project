package com.johnthedev.com.mywebshop;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.johnthedev.com.mywebshop.dao.ProductRepository;
import com.johnthedev.com.mywebshop.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductCrudTest{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void saveProductTest() {
		
		Product product = new Product("Floppy", 1500, 0, 15);
		
		productRepository.save(product);
		
		Assertions.assertThat(product.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void getProductByIdTest() {
		
		Optional<Product> product = productRepository.findById(1);
		
		Product prod = product.get();
		
		Assertions.assertThat(prod.getId()).isGreaterThan(0);
		
	}
}
