package com.johnthedev.com.mywebshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnthedev.com.mywebshop.entity.Order;
import com.johnthedev.com.mywebshop.entity.OrderStatus;
import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;
import com.johnthedev.com.mywebshop.entity.ShoppingCartItem;
import com.johnthedev.com.mywebshop.entity.User;
import com.johnthedev.com.mywebshop.service.OrderService;
import com.johnthedev.com.mywebshop.service.ProductService;
import com.johnthedev.com.mywebshop.service.UserService;

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

	@Autowired
	public UserService userService;
//
//	@Autowired
//	public CustomerService customerService;

	@GetMapping("/list")
	public String listOrders(Model theModel) {

		Order theOrders = orderService.findLast();

		theModel.addAttribute("order", theOrders);

		return "orders/list-order";
	}

	@GetMapping("/listOrders")
	public String listAllOrders(Model theModel) {

		List<Order> theOrders = orderService.findAll();

		theModel.addAttribute("order", theOrders);

		return "orders/list-orders";
	}

	@GetMapping("/save")
	public String saveOrder() {
		
		String username=new String();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		User user = new User();

		user = userService.findByEmail(username);

		ShoppingCart tShoppingCart = new ShoppingCart();

		tShoppingCart.setListOfShoppingCartProducts(theShoppingCart.getListOfShoppingCartProducts());

		Order order = new Order();
		order.setUserId(user.getId());
		order.setUserName(username);
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

		return "redirect:/orders/listActualCustomersOrders";
	}

	@GetMapping("/approve")
	public String approveOrder(@RequestParam("orderId") int theId) {

		Order tempOrder = new Order();

		tempOrder = orderService.findById(theId);

		if (tempOrder.getOrderStatus() == OrderStatus.MODIFIABLE) {

			tempOrder.setOrderStatus(OrderStatus.APPROVED);

			orderService.save(tempOrder);

		}

		return "redirect:/orders/listOrders";
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

		return "redirect:/orders/listOrders";
	}
	
	@GetMapping("/abortOrderByCustomer")
	public String abortOrderByCustomer(@RequestParam("orderId") int theId) {

		Order tempOrder = new Order();

		tempOrder = orderService.findById(theId);

//		if (tempOrder.getOrderStatus() == OrderStatus.MODIFIABLE) {

			tempOrder.setOrderStatus(OrderStatus.ABORT);

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
//		}

		return "redirect:/orders/listActualCustomersOrders";
	}
	

	@GetMapping("/listActualCustomersOrders")
	public String showCustomerOrdes(Model theModel) {
		String username=new String();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		User tempUser = new User();
		tempUser = userService.findByEmail(username);
		
		List<Order> theOrders = orderService.findAll();
		List<Order> userOrders= new ArrayList<Order>(); 
		for (Order temp : theOrders) {
			if (temp.getUserName() != null) {	
				if (temp.getUserName().toString().equals(username)) {
					userOrders.add(temp);
				}
			}
		}
		theModel.addAttribute("order", userOrders);
		theModel.addAttribute("customer", tempUser);

		return "orders/customer_data";
	}
}
