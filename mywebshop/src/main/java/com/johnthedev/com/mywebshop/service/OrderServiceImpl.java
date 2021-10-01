package com.johnthedev.com.mywebshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnthedev.com.mywebshop.dao.OrderRepository;
import com.johnthedev.com.mywebshop.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository theOrderRepository) {
		orderRepository=theOrderRepository;
	}

	@Override
	public List<Order> findAll() {
		
		return orderRepository.findAll();
	}

	@Override
	public Order findById(int theId) {
		
		Optional<Order> result = orderRepository.findById(theId);
		
		Order theOrder = null;
		
		if(result.isPresent()) {
			theOrder =  result.get();
		} else {
			throw new RuntimeException("Order id not found: \" + theId");
		}
		return theOrder;
	}
	
	@Override
	public Order findLast() {
		
		List<Order> result = new ArrayList<Order>();
		
		result = orderRepository.findAll();
		
		return result.get(result.size()-1);
		
	}

	@Override
	public void save(Order theOrder) {
		
		orderRepository.save(theOrder);

	}

	@Override
	public void deleteById(int id) {

	}

}
