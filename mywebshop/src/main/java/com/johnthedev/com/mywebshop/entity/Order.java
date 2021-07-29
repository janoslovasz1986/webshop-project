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
import javax.persistence.Transient;

@Entity
@Table(name="shoppingcart_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int id; 
	
	@Transient
	private Customer customer;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Embedded
	private ShoppingCart shoppingCart;
	
	@Column(name="order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	
	
	
	public Order() {
	
	}

	public Order(Customer customer, ShoppingCart shoppingCart) {
		this.customer = customer;
		this.shoppingCart = shoppingCart;
	}
	
	
		

	public Order(Customer customer, int customerId, ShoppingCart shoppingCart, OrderStatus orderStatus) {
		this.customer = customer;
		this.customerId = customerId;
		this.shoppingCart = shoppingCart;
		this.orderStatus = orderStatus;
	}
	
	

	public Order(Customer customer, ShoppingCart shoppingCart, OrderStatus orderStatus) {
		this.customer = customer;
		this.shoppingCart = shoppingCart;
		this.orderStatus = orderStatus;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", shoppingCart=" + shoppingCart + "]";
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
		Order other = (Order) obj;
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
