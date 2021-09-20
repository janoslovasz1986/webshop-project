package com.johnthedev.com.mywebshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnthedev.com.mywebshop.dto.CustomerDto;
import com.johnthedev.com.mywebshop.mapper.CustomerDtoMapper;
import com.johnthedev.com.mywebshop.mapper.CustomerToUserMapper;
import com.johnthedev.com.mywebshop.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService theCustomerService) {
		
		customerService = theCustomerService;
	}
	
	@Autowired
	public CustomerDtoMapper customerDtoMapper;
	
	@Autowired
	public CustomerToUserMapper customerToUserMapper;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<CustomerDto> theCustomers = customerDtoMapper.customerEntityListToCustomerDtoListMapper(customerService.findAll());
		
		theModel.addAttribute("customers", theCustomers);
		
		return "customers/list-customers";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		CustomerDto theCustomer = customerDtoMapper.customerEntityToCustomerDtoMapper(customerService.findById(theId));
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customers/customer-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		CustomerDto theCustomer = new CustomerDto();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customers/customer-form";
	}
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") CustomerDto theCustomer) {
		
		customerService.save(customerDtoMapper.customerDtoToCustomerEntityMapper(theCustomer));
		
		customerToUserMapper.fromCustomerToUserMapper(customerDtoMapper.customerDtoToCustomerEntityMapper(theCustomer));
		
		return "redirect:/customers/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteById(theId);
		
		return "redirect:/customers/list";
	}

}
