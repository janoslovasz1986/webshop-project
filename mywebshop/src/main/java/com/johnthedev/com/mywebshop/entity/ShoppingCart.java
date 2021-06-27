package com.johnthedev.com.mywebshop.entity;

import java.util.List;

public class ShoppingCart {
	
	private List<ShoppingCartItem> listOfShoppingCartProducts;
	
	public ShoppingCart() {
		
	}

	public List<ShoppingCartItem> getListOfShoppingCartProducts() {
		return listOfShoppingCartProducts;
	}

	public void setListOfShoppingCartProducts(List<ShoppingCartItem> listOfShoppingCartProducts) {
		this.listOfShoppingCartProducts = listOfShoppingCartProducts;
	}

	@Override
	public String toString() {
		return "ShoppingCart [listOfShoppingCartProducts=" + listOfShoppingCartProducts + "]";
	}
	
	

}
