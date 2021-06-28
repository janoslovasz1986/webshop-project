package com.johnthedev.com.mywebshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;
import com.johnthedev.com.mywebshop.entity.ShoppingCartItem;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	private ShoppingCartItem shoppingCartItem;
	
	public ShoppingCart shoppingCart; 
	/*
	@Autowired
	public ShoppingCartController(ShoppingCartItem theShoppingCartItem) {
		
		shoppingCartItem=theShoppingCartItem;
	}
	*/


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
		
		
		ShoppingCartItem theShoppingCartItem1 = new ShoppingCartItem();
		ShoppingCartItem theShoppingCartItem2 = new ShoppingCartItem();
		
		theShoppingCartItem1 = new ShoppingCartItem(new Product("aaa", 1000, 0), 2);
		theShoppingCartItem2 = new ShoppingCartItem(new Product("bbb", 2000, 0), 3);
		
		ShoppingCart shoppingCart = new ShoppingCart();
		
		shoppingCart.addProduct(theShoppingCartItem1);
		shoppingCart.addProduct(theShoppingCartItem2);
		
		System.out.println(shoppingCart);
		
		
		
		theModel.addAttribute("shoppingCart" , shoppingCart);
		

		
		
		return "shoppingcart/shoppingcart";
	}

}
