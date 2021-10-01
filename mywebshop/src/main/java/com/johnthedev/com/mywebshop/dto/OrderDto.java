package com.johnthedev.com.mywebshop.dto;

import com.johnthedev.com.mywebshop.entity.ShoppingCart;

public class OrderDto {
	
	private int id; 
	private long userId;
	private String userName;
	private ShoppingCart shoppingCart;
	private String address;
	
	
	public OrderDto() {
		
	}


	public OrderDto(int id, long userId, ShoppingCart shoppingCart, String address, String userName) {
		this.id = id;
		this.userId = userId;
		this.shoppingCart = shoppingCart;
		this.address = address;
		this.userName=userName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
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
		return "OrderDto [id=" + id + ", userId=" + userId + ", userName=" + userName + ", shoppingCart=" + shoppingCart
				+ ", address=" + address + "]";
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((shoppingCart == null) ? 0 : shoppingCart.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (shoppingCart == null) {
			if (other.shoppingCart != null)
				return false;
		} else if (!shoppingCart.equals(other.shoppingCart))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	
	
	

}
