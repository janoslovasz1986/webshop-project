package com.johnthedev.com.mywebshop.entity;

import java.util.HashMap;


public class ShoppingCart {

	private HashMap<Product, Integer> shoppingCartProducts;
	
	public ShoppingCart() {		
	}

	public ShoppingCart(HashMap<Product, Integer> shoppingCartProducts) {
		this.shoppingCartProducts = shoppingCartProducts;
	}

	public HashMap<Product, Integer> getShoppingCartProducts() {
		return shoppingCartProducts;
	}

	public void setShoppingCartProducts(HashMap<Product, Integer> shoppingCartProducts) {
		this.shoppingCartProducts = shoppingCartProducts;
	}

	@Override
	public String toString() {
		return "ShoppingCart [shoppingCartProducts=" + shoppingCartProducts + "]";
	}


	
	
	
}
