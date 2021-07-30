package com.johnthedev.com.mywebshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnthedev.com.mywebshop.entity.Customer;
import com.johnthedev.com.mywebshop.entity.Order;
import com.johnthedev.com.mywebshop.entity.OrderStatus;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;
import com.johnthedev.com.mywebshop.entity.ShoppingCartItem;
import com.johnthedev.com.mywebshop.service.OrderService;
import com.johnthedev.com.mywebshop.service.ProductService;

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
	
	@Autowired
	public ProductService productService;

	@GetMapping("/list")
	public String listOrders(Model theModel) {

		Order theOrders = orderService.findLast();

		theModel.addAttribute("order", theOrders);

		return "orders/list-order";
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
		order.setOrderStatus(OrderStatus.MODIFIABLE);
	
		orderService.save(order);
		
		
		Map<Integer, Integer> soldProducts= new HashMap<Integer, Integer>();
		
		List<ShoppingCartItem> soldShoppingCartItems= new ArrayList<ShoppingCartItem>();
		soldShoppingCartItems = tShoppingCart.getListOfShoppingCartProducts();
		
		
		
		return "redirect:/orders/list";
	}

}
