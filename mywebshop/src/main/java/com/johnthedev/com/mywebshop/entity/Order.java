package com.johnthedev.com.mywebshop.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoppingcart_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int id; 
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Embedded
	private ShoppingCart shoppingCart;
	
	@Column(name="order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;


	
	public Order() {
	
	}



	public Order(int id, long userId, String userName, ShoppingCart shoppingCart, OrderStatus orderStatus) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.shoppingCart = shoppingCart;
		this.orderStatus = orderStatus;
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



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}



	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}



	public OrderStatus getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}



	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", userName=" + userName + ", shoppingCart=" + shoppingCart
				+ ", orderStatus=" + orderStatus + "]";
	}







}
