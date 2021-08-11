package com.johnthedev.com.mywebshop.configuration.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnthedev.com.mywebshop.configuration.security.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	User findByUserName(String userName);

}
