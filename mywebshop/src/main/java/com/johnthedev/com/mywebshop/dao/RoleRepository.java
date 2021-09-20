package com.johnthedev.com.mywebshop.dao;

import org.springframework.data.repository.CrudRepository;

import com.johnthedev.com.mywebshop.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByRole(String role);

}
