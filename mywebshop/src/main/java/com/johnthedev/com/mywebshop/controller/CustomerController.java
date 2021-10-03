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
import com.johnthedev.com.mywebshop.entity.User;
import com.johnthedev.com.mywebshop.mapper.CustomerDtoMapper;
import com.johnthedev.com.mywebshop.mapper.CustomerToUserMapper;
import com.johnthedev.com.mywebshop.service.CustomerService;
import com.johnthedev.com.mywebshop.service.UserService;
import com.johnthedev.com.mywebshop.service.email.EmailService;

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
	
	@Autowired
	public UserService theUserService;
	
	@Autowired
	public EmailService theEmailService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<CustomerDto> theCustomers = customerDtoMapper.customerEntityListToCustomerDtoListMapper(customerService.findAll());
		List<User> theUsers = theUserService.findAllUsers();

		
		theModel.addAttribute("customers", theCustomers);
		theModel.addAttribute("users", theUsers);
		
		return "customers/list-customers";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") long theId, Model theModel) {
		
		
		User theUser =  theUserService.findUserById(theId);
		
		theModel.addAttribute("customer", theUser);
		
		return "customers/customer-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		User theUser = new User();
		theModel.addAttribute("customer", theUser);
		return "customers/customer-form";
	}
	
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") User theUser) {

		System.out.println(theUser.toString());
		if (theUser.getId() == null) {
			theUserService.registerUser(theUser);
			theEmailService.sendMessage(theUser.getEmail());  //send email form customer about successful registration 
			
		} else {
			theUserService.updateUserData(theUser);
		}
		
		return "redirect:/customers/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteById(theId);
		
		return "redirect:/customers/list";
	}

}
