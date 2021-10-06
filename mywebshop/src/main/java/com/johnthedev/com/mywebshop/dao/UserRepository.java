package com.johnthedev.com.mywebshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnthedev.com.mywebshop.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

	User findByActivation(String code);

}
