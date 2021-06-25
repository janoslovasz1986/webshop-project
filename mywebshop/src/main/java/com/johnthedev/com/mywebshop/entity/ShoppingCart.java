package com.johnthedev.com.mywebshop.entity;

import java.util.HashMap;
import java.util.Map;


public class ShoppingCart {

	private Customer shoppingCartCustomer;
	private HashMap<Product, Integer> shoppingCartProducts;
	
	public ShoppingCart() {		
	}

	public ShoppingCart(Customer shoppingCartCustomer, HashMap<Product, Integer> shoppingCartProducts) {
		this.shoppingCartCustomer = shoppingCartCustomer;
		this.shoppingCartProducts = shoppingCartProducts;
	}

	public Customer getShoppingCartCustomer() {
		return shoppingCartCustomer;
	}

	public void setShoppingCartCustomer(Customer shoppingCartCustomer) {
		this.shoppingCartCustomer = shoppingCartCustomer;
	}

	public Map<Product, Integer> getShoppingCartProducts() {
		return shoppingCartProducts;
	}

	public void setShoppingCartProducts(HashMap<Product, Integer> shoppingCartProducts) {
		this.shoppingCartProducts = shoppingCartProducts;
	}

	@Override
	public String toString() {
		return "ShoppingCart [shoppingCartCustomer=" + shoppingCartCustomer + ", shoppingCartProducts="
				+ shoppingCartProducts + "]";
	}
	
	
	
	
}
