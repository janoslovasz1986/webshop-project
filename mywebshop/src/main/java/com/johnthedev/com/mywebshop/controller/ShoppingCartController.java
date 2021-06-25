package com.johnthedev.com.mywebshop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.johnthedev.com.mywebshop.entity.Customer;
import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;

@Controller("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	public ShoppingCart shoppingCart;
	
	
	@GetMapping("/addToShoppingCart")
	public String addToShoppingCart(@RequestAttribute("productId") int theId) {
		
		ShoppingCart theShoppingCart = new ShoppingCart();
				
			theShoppingCart.setShoppingCartCustomer(new Customer("xcv", "xcv", "xcv")); 
			
			Map<Product,Integer> tempShoppingCartProducts= new HashMap<Product,Integer>();
			tempShoppingCartProducts.put(new Product("aaa", 1000, 0), null);
			
			theShoppingCart.setShoppingCartProducts(null);
			
			
			
		
		
		
		return "/products/list-products";
	}
	
}
