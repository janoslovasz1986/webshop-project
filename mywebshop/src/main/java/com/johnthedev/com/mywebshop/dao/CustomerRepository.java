package com.johnthedev.com.mywebshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnthedev.com.mywebshop.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findAllByOrderByLastNameAsc();
}
