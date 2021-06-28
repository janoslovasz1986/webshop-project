package com.johnthedev.com.mywebshop.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private int orderNum;
	
	private Customer customer;
	
	private List<ShoppingCartItem> listOfShoppingCartProducts = new ArrayList<ShoppingCartItem>();
	
	public ShoppingCart() {
		
	}

	public ShoppingCart(int orderNum, Customer customer, List<ShoppingCartItem> listOfShoppingCartProducts) {
		this.orderNum = orderNum;
		this.customer = customer;
		this.listOfShoppingCartProducts = listOfShoppingCartProducts;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ShoppingCartItem> getListOfShoppingCartProducts() {
		return listOfShoppingCartProducts;
	}

	public void setListOfShoppingCartProducts(List<ShoppingCartItem> listOfShoppingCartProducts) {
		this.listOfShoppingCartProducts = listOfShoppingCartProducts;
	}

	@Override
	public String toString() {
		return "ShoppingCart [orderNum=" + orderNum + ", customer=" + customer + ", listOfShoppingCartProducts="
				+ listOfShoppingCartProducts + "]";
	}
	
	public void addProduct(ShoppingCartItem shoppingCartItem) {
		
		listOfShoppingCartProducts.add(shoppingCartItem);
		
	}
	
	public Double calcSumPrice() {
		
		double sum =0;
		
		for(ShoppingCartItem tempCartItem : listOfShoppingCartProducts) {
			
			sum = sum + tempCartItem.getAmount();
		}
		
		return sum;
	}
	
	

	
	
	

}
