package com.johnthedev.com.mywebshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnthedev.com.mywebshop.dao.ProductRepository;
import com.johnthedev.com.mywebshop.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository theProductRepository) {
		productRepository = theProductRepository;
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> products = new ArrayList<Product>();
		
		products = productRepository.findAll();
		
		return products;
	}

	@Override
	public Product findById(int theId) {
		
		Optional<Product> result = productRepository.findById(theId);
		
		Product theProduct = null;
		
		if(result.isPresent()) {
			theProduct =  result.get();
		} else {
			throw new RuntimeException("Product id not found: \" + theId");
		}
		return theProduct;
		
	}

	@Override
	public void save(Product theProduct) {
		
		productRepository.save(theProduct);
		
		
	}

	@Override
	public void deleteById(int id) {
		
		productRepository.deleteById(id);
		
	}

}
