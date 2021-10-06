//package com.johnthedev.com.mywebshop.mapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.johnthedev.com.mywebshop.entity.Customer;
//import com.johnthedev.com.mywebshop.entity.User;
//import com.johnthedev.com.mywebshop.service.UserServiceImpl;
//
//public class CustomerToUserMapper {
//	
//	@Autowired
//	private UserServiceImpl theUserServiceImpl;
//	
//	public void fromCustomerToUserMapper(Customer theCustomer) {
//		
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		
//		User theUser = new User();
//		
//		theUser.setActivation("active");
//		theUser.setEmail(theCustomer.getEmail());
//		theUser.setEnabled(true);
//		theUser.setFullName(theCustomer.getFirstName() + " " + theCustomer.getLastName());
//		theUser.setPassword(encoder.encode(theCustomer.getPassword()));
//
//		
//		theUserServiceImpl.registerUser(theUser);
//		
//	}
//	
//	
//
//}
