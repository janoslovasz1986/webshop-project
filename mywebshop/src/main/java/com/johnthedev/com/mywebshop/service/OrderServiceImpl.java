package com.johnthedev.com.mywebshop.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Order theOrder) {
		
		orderRepository.save(theOrder);

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
