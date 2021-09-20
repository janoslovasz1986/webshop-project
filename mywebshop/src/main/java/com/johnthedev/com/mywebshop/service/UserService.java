package com.johnthedev.com.mywebshop.service;

import com.johnthedev.com.mywebshop.entity.User;

public interface UserService {
	
	public String registerUser(User user);

	public User findByEmail(String email);

	public String userActivation(String code);

}
