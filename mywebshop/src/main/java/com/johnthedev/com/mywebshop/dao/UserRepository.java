package com.johnthedev.com.mywebshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.johnthedev.com.mywebshop.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);

	User findByActivation(String code);

}
