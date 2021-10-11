package com.johnthedev.com.mywebshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		
		return productService.findAll();
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		

		product.setId(0);
		
		productService.save(product);
		
		return product;
	}
	
	@PutMapping("/modifyProductDiscount")
	public Product modifyProductDiscount(int theId, int discount) {
		
		Product product = productService.findById(theId);
		
		product.setDiscount(discount);
		
		productService.save(product);
		
		return product;
		
	}

}
