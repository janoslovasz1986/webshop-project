package com.johnthedev.com.mywebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		orderService = theOrderService;
	}

	@Autowired
	public ShoppingCart theShoppingCart;

	@GetMapping("/list")
	public String listOrders(Model theModel) {

		// List<OrderDto> theOrders =
		// orderDtoMapper.orderEntityListToOrderDtoListMapper(orderService.findAll());

		// theModel.addAttribute("products", theOrders);

		return "products/list-products";
	}

	@GetMapping("/save")
	public String saveOrder() {

		Customer tempCustomer = new Customer(11, "Jack", "Hopkins", "jackie@gmail.com");
		
		ShoppingCart tShoppingCart = new ShoppingCart();

		tShoppingCart.setListOfShoppingCartProducts(theShoppingCart.getListOfShoppingCartProducts());
		
		Order order = new Order();
		order.setCustomer(tempCustomer);
		order.setCustomerId(111);
		order.setShoppingCart(tShoppingCart);
		
		orderService.save(order);
		
		return "";
	}

}
