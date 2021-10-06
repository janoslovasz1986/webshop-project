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

import com.johnthedev.com.mywebshop.entity.User;
import com.johnthedev.com.mywebshop.service.UserService;
import com.johnthedev.com.mywebshop.service.email.EmailService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	private UserService theUserService;

	public CustomerController(UserService userService) {
		
		theUserService = userService;
		
	}

	@Autowired
	public EmailService theEmailService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<User> theUsers = theUserService.findAllUsers();

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
	public String saveCustomer(@ModelAttribute("customer") User theUser, @ModelAttribute("customerRoles") String tempRoles) {

		System.out.println("customer controller: " + theUser.toString());
		System.out.println("temproles: " + tempRoles);
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
		
		theUserService.deleteById(theId);
		
		return "redirect:/customers/list";
	}

}
