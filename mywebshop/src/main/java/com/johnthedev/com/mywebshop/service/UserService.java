package com.johnthedev.com.mywebshop.service;

import java.util.List;

import com.johnthedev.com.mywebshop.entity.User;

public interface UserService {
	
	public String registerUser(User user);

	public User findByEmail(String email);

	public String userActivation(String code);
	
	public List<User> findAllUsers();
	
	public User findUserById(long theId);

	public void updateUserData(User theUser);

}
