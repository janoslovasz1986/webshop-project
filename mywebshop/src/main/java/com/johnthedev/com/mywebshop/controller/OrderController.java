package com.johnthedev.com.mywebshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnthedev.com.mywebshop.dto.OrderDto;
import com.johnthedev.com.mywebshop.entity.Customer;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;
import com.johnthedev.com.mywebshop.mapper.OrderDtoMapper;
import com.johnthedev.com.mywebshop.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService theOrderService) {
		orderService=theOrderService;
	}
	
	@Autowired
	public ShoppingCart theShoppingCart;
	
	//@Autowired
	//public Customer theCustomer;
	
	@Autowired
	public OrderDtoMapper orderDtoMapper;
	
	@GetMapping("/list")
	public String listOrders(Model theModel) {
		
		List<OrderDto> theOrders = orderDtoMapper.orderEntityListToOrderDtoListMapper(orderService.findAll());
		
		theModel.addAttribute("products", theOrders);
		
		
		return "products/list-products";
	}
	
	@GetMapping("/save")
	//public String saveOrder(@ModelAttribute("order") ShoppingCart theShoppingCart) {
	public String saveOrder(Model theModel) {
	
		theShoppingCart.setId(1);
		System.out.println(theShoppingCart);
		
		Customer tempCustomer = new Customer(11, "Jack", "Hopkins", "jackie@gmail.com");
		
		OrderDto orderDto = new OrderDto(); 
		
		orderDto.setCustomer(tempCustomer);
		orderDto.setShoppingCart(theShoppingCart);
		
		System.out.println(orderDto);
	
		
		
		orderService.save(orderDtoMapper.orderDtoToOrderEntityMapper(orderDto));
		
		
		
		return "list-orders";
	}

}
