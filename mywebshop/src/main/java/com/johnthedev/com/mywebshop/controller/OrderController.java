package com.johnthedev.com.mywebshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnthedev.com.mywebshop.entity.Customer;
import com.johnthedev.com.mywebshop.entity.Order;
import com.johnthedev.com.mywebshop.entity.OrderStatus;
import com.johnthedev.com.mywebshop.entity.Product;
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
	
//	@Autowired
//	public UserService userService;

	@GetMapping("/list")
	public String listOrders(Model theModel) {

		Order theOrders = orderService.findLast();

		theModel.addAttribute("order", theOrders);

		return "orders/list-order";
	}

	@GetMapping("/listorders")
	public String listAllOrders(Model theModel) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
//		User user = userService.findUserByUserName(auth.getName());

		List<Order> theOrders = orderService.findAll();

		theModel.addAttribute("order", theOrders);
		
//		theModel.addAttribute("userName", user.getName());

		return "orders/list-orders";
	}

	@GetMapping("/save")
	public String saveOrder() {

		Customer tempCustomer = new Customer();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = userService.findUserByUserName(auth.getName());
		
//		tempCustomer.setEmail(user.getEmail());
//		tempCustomer.setFirstName(user.getName());
//		tempCustomer.setId(user.getId());
//		tempCustomer.setLastName(user.getLastName());
		
		
		ShoppingCart tShoppingCart = new ShoppingCart();

		tShoppingCart.setListOfShoppingCartProducts(theShoppingCart.getListOfShoppingCartProducts());

		Order order = new Order();
		order.setCustomer(tempCustomer);
		order.setCustomerId(tempCustomer.getId());
		order.setShoppingCart(tShoppingCart);
		order.setOrderStatus(OrderStatus.MODIFIABLE);

		orderService.save(order);

		Map<Integer, Integer> soldProducts = new HashMap<Integer, Integer>();

		List<ShoppingCartItem> soldShoppingCartItems = new ArrayList<ShoppingCartItem>();
		soldShoppingCartItems = tShoppingCart.getListOfShoppingCartProducts();

		for (ShoppingCartItem sci : soldShoppingCartItems) {
			soldProducts.put(sci.getInShoppingCartProduct().getId(), sci.getInShoppingCartProductQuantity());
		}

		List<Product> soldProductsToDecreaseQuantity = new ArrayList<Product>();
		soldProductsToDecreaseQuantity = null;

		soldProductsToDecreaseQuantity = productService.findAll();

		for (Product tempProduct : soldProductsToDecreaseQuantity) {
			if (soldProducts.containsKey(tempProduct.getId())) {
				tempProduct
						.setInStockQuantity(tempProduct.getInStockQuantity() - (soldProducts.get(tempProduct.getId())));
			}
		}

		for (Product tempProduct : soldProductsToDecreaseQuantity) {

			productService.save(tempProduct);

		}

		return "redirect:/orders/listorders";
	}

	@GetMapping("/approve")
	public String approveOrder(@RequestParam("orderId") int theId) {

		Order tempOrder = new Order();

		tempOrder = orderService.findById(theId);

		if (tempOrder.getOrderStatus() == OrderStatus.MODIFIABLE) {

			tempOrder.setOrderStatus(OrderStatus.APPROVED);

			orderService.save(tempOrder);
			
		}
		
		return "redirect:/orders/listorders";
	}

	@GetMapping("/deleteOrderOnCustomerRequest")
	public String deleteOrderOnCustomerRequest(@RequestParam("orderId") int theId) {

		Order tempOrder = new Order();

		tempOrder = orderService.findById(theId);

		if (tempOrder.getOrderStatus() == OrderStatus.MODIFIABLE) {

			tempOrder.setOrderStatus(OrderStatus.DELETED);

			orderService.save(tempOrder);

			Map<Integer, Integer> unSoldProducts = new HashMap<Integer, Integer>();

			List<ShoppingCartItem> tempShoppingCartItems = new ArrayList<ShoppingCartItem>();
			tempShoppingCartItems = tempOrder.getShoppingCart().getListOfShoppingCartProducts();

			for (ShoppingCartItem theShoppingCartItem : tempShoppingCartItems) {
				unSoldProducts.put(theShoppingCartItem.getInShoppingCartProduct().getId(),
						theShoppingCartItem.getInShoppingCartProductQuantity());

			}

			List<Product> productsToIncreaseQuantity = new ArrayList<Product>();

			productsToIncreaseQuantity = productService.findAll();

			for (Product tempProduct : productsToIncreaseQuantity) {

				if (unSoldProducts.containsKey(tempProduct.getId())) {
					tempProduct.setInStockQuantity(
							tempProduct.getInStockQuantity() + (unSoldProducts.get(tempProduct.getId())));
				}
			}

			for (Product tempProduct : productsToIncreaseQuantity) {

				productService.save(tempProduct);

			}
		}

		return "redirect:/orders/listorders";
	}

}
