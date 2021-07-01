package com.johnthedev.com.mywebshop.entity;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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

	public ShoppingCart(List<ShoppingCartItem> listOfShoppingCartProducts) {
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

		//if (listOfShoppingCartProducts.isEmpty()) {

		//	listOfShoppingCartProducts.add(shoppingCartItem);
		//}

		for (ShoppingCartItem theShoppingCartItem : listOfShoppingCartProducts) {
			if (theShoppingCartItem.getInShoppingCartProduct().getId() == shoppingCartItem.getInShoppingCartProduct()
					.getId()) {

				theShoppingCartItem
						.setInShoppingCartProductQuantity(theShoppingCartItem.getInShoppingCartProductQuantity() + 1);

			} 
		}
		
		listOfShoppingCartProducts.add(shoppingCartItem);
		

	}

	public void removeProduct(ShoppingCartItem shoppingCartItem) {

		for (ShoppingCartItem theShoppingCartItem : listOfShoppingCartProducts) {

			if (theShoppingCartItem.equals(shoppingCartItem)) {

				listOfShoppingCartProducts.remove(theShoppingCartItem);
				break;
			}
		}

	}

	public void removeAllProducts() {

		listOfShoppingCartProducts.clear();

	}

	public Double calcSumPrice() {

		double sum = 0;

		for (ShoppingCartItem tempCartItem : listOfShoppingCartProducts) {

			sum = sum + tempCartItem.getAmount();
		}

		return sum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listOfShoppingCartProducts == null) ? 0 : listOfShoppingCartProducts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		if (listOfShoppingCartProducts == null) {
			if (other.listOfShoppingCartProducts != null)
				return false;
		} else if (!listOfShoppingCartProducts.equals(other.listOfShoppingCartProducts))
			return false;
		return true;
	}

}
