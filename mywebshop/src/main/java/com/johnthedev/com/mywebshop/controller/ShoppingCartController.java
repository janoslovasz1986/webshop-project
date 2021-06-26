package com.johnthedev.com.mywebshop.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	private ShoppingCart shoppingCart;
	
	@Autowired
	public ShoppingCartController(ShoppingCart theShoppingCart) {
		
		shoppingCart=theShoppingCart;
	}

	@GetMapping("/addToShoppingCart")
	public String addToShoppingCart(@RequestAttribute("productId") int theId, Model theModel) {
		
		HashMap<Product, Integer> tempShoppingCartProducts = new HashMap<Product, Integer>();
		tempShoppingCartProducts.put(new Product("aaa", 1000, 0), null);
		
		shoppingCart.setShoppingCartProducts(tempShoppingCartProducts);
		theModel.addAttribute(shoppingCart);
	
		return "shoppingCart/shoppingcart.html";
	}
	
	@GetMapping("/list")
	public String listShoppingCart(Model theModel) {
		
		HashMap<Product, Integer> tempShoppingCartProducts = new HashMap<Product, Integer>();
		tempShoppingCartProducts.put(new Product("aaa", 1000, 0), 1);
		tempShoppingCartProducts.put(new Product("bbb", 2000, 0), 2);
		
		shoppingCart.setShoppingCartProducts(tempShoppingCartProducts);
		
		theModel.addAttribute("shoppingCart",shoppingCart);
		
		
		return "shoppingcart/shoppingcart";
	}

}
