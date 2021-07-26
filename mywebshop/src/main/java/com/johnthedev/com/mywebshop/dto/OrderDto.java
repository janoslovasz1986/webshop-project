package com.johnthedev.com.mywebshop.dto;

import com.johnthedev.com.mywebshop.entity.Customer;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;

public class OrderDto {
	
	private int id; 
	private Customer customer;
	private ShoppingCart shoppingCart;
	private String address;
	
	
	public OrderDto() {
		
	}

	public OrderDto(int id, Customer customer, ShoppingCart shoppingCart) {
		this.id = id;
		this.customer = customer;
		this.shoppingCart = shoppingCart;
	}

	public OrderDto(Customer customer, ShoppingCart shoppingCart) {
		this.customer = customer;
		this.shoppingCart = shoppingCart;
	}

	
	
	public OrderDto(int id, Customer customer, ShoppingCart shoppingCart, String address) {
		this.id = id;
		this.customer = customer;
		this.shoppingCart = shoppingCart;
		this.address = address;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", customer=" + customer + ", shoppingCart=" + shoppingCart + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
		result = prime * result + ((shoppingCart == null) ? 0 : shoppingCart.hashCode());
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
		OrderDto other = (OrderDto) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (shoppingCart == null) {
			if (other.shoppingCart != null)
				return false;
		} else if (!shoppingCart.equals(other.shoppingCart))
			return false;
		return true;
	}
	
	
	
	
	
	

}
