//package com.johnthedev.com.mywebshop.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import com.johnthedev.com.mywebshop.dao.CustomerRepository;
//import com.johnthedev.com.mywebshop.entity.Customer;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//	private CustomerRepository customerRepository;
//
//	public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
//		customerRepository = theCustomerRepository;
//	}
//
//	@Override
//	public List<Customer> findAll() {
//
//		List<Customer> theCustomers = customerRepository.findAll();
//
//		return theCustomers;
//	}
//
//	@Override
//	public Customer findById(int theId) {
//
//		Optional<Customer> result = customerRepository.findById(theId);
//
//		Customer theCustomer = null;
//
//		if (result.isPresent()) {
//			theCustomer = result.get();
//		} else {
//			// we didnt find the employee so throw exception
//			throw new RuntimeException("Customer id not found: " + theId);
//		}
//		return theCustomer;
//	}
//
//	@Override
//	public void save(Customer theCustomer) {
//		
//		customerRepository.save(theCustomer);
//
//	}
//
//	@Override
//	public void deleteById(int theId) {
//		
//		customerRepository.deleteById(theId);
//
//	}
//
//}
