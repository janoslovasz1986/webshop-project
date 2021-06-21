package com.johnthedev.com.mywebshop.service;

import java.util.List;

import com.johnthedev.com.mywebshop.entity.Customer;


public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int id);
	
}
