package com.johnthedev.com.mywebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnthedev.com.mywebshop.entity.Customer;
import com.johnthedev.com.mywebshop.entity.Order;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;
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
	
	@GetMapping("/list")
	public String listOrders() {
		
		return "";
	}
	
	@GetMapping("/save")
	public String saveOrder(@ModelAttribute("order") Order theOrder) {
		
		Customer tempCustomer = new Customer(11, "John", "Snow", "jsnow@gmail.com");
		
		theOrder.setCustomer(tempCustomer);
		theOrder.setShoppingCart(theShoppingCart);
	
		
		
		orderService.save(theOrder);
		
		return "";
	}

}
