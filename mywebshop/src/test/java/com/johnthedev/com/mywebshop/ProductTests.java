package com.johnthedev.com.mywebshop;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.johnthedev.com.mywebshop.dao.ProductRepository;
import com.johnthedev.com.mywebshop.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductTests {
	
	@Autowired
	private ProductRepository repo;
	
	
	@Test
	@Rollback(true)
	public void TestCreateProduct() {
		
		Product product = new Product(1, "Floppy", 1500, 0, 15,"");
		Product savedProduct = repo.save(product);
		
		assertNotNull(savedProduct);
	}
	
	


}
