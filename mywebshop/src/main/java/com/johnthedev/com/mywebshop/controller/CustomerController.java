package com.johnthedev.com.mywebshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnthedev.com.mywebshop.entity.Customer;
import com.johnthedev.com.mywebshop.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService theCustomerService) {
		
		customerService = theCustomerService;
	}
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomers = customerService.findAll();
		
		theModel.addAttribute("customers", theCustomers);
		
		return "customers/list-customers";
	}

}
