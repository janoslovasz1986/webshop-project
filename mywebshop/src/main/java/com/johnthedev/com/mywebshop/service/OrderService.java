package com.johnthedev.com.mywebshop.service;

import java.util.List;

import com.johnthedev.com.mywebshop.entity.Order;

public interface OrderService {
	
	public List<Order> findAll();
	
	public Order findById(int theId);
	
	public void save(Order theOrder);
	
	public void deleteById(int id);

	public Order findLast();

}
