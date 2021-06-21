package com.johnthedev.com.mywebshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.johnthedev.com.mywebshop.dao.CustomerRepository;
import com.johnthedev.com.mywebshop.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
		customerRepository = theCustomerRepository;
	}
	
	@Override
	public List<Customer> findAll() {
		
		List<Customer> theCustomers = customerRepository.findAll();
		
		return theCustomers;
	}

	@Override
	public Customer findById(int theId) {
		
		return null;
	}

	@Override
	public void save(Customer theCustomer) {

	}

	@Override
	public void deleteById(int id) {

	}

}
