package com.johnthedev.com.mywebshop.service;

import java.util.List;

import com.johnthedev.com.mywebshop.entity.Product;

public interface ProductService{
	
	public List<Product> findAll();
	
	public Product findById(int theId);
	
	public void save(Product theProduct);
	
	public void deleteById(int id);

	public List<Product> searchProducts(String theSearchName);

}
