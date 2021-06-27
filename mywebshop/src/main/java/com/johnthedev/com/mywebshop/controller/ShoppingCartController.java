package com.johnthedev.com.mywebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.entity.ShoppingCartItem;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	private ShoppingCartItem shoppingCartItem;
	
	@Autowired
	public ShoppingCartController(ShoppingCartItem theShoppingCartItem) {
		
		shoppingCartItem=theShoppingCartItem;
	}

	/*
	@GetMapping("/addToShoppingCart")
	public String addToShoppingCart(@RequestAttribute("productId") int theId, Model theModel) {
		
		ShoppingCartItem tempShoppingCartItem = new ShoppingCartItem(new Product("aaa", 1000, 0), 1);
		
		theModel.addAttribute("shoppingCartItem" , tempShoppingCartItem);
	
		return "shoppingCart/shoppingcart.html";
	}
	*/
	@GetMapping("/list")
	public String listShoppingCart(Model theModel) {
		
		//ShoppingCartItem theShoppingCartItem = new ShoppingCartItem(new Product("aaa", 1000, 0), 1);
		
		ShoppingCartItem theShoppingCartItem = new ShoppingCartItem();
		
		theShoppingCartItem = new ShoppingCartItem(new Product("aaa", 1000, 0), 2);
		
		//shoppingCartItem.setInshoppingCartProduct(new Product("aaa", 1000, 0));
		//shoppingCartItem.setInShoppingCartProductQuantity(1);
		
		System.out.println(theShoppingCartItem);
		theModel.addAttribute("shoppingCartItem" , theShoppingCartItem);
		

		
		
		return "shoppingcart/shoppingcart";
	}

}
