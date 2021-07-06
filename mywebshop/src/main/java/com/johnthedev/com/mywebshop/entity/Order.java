package com.johnthedev.com.mywebshop.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	//@OneToOne
	//@JoinColumn(
	//		name="id",
	//		referencedColumnName="id"
	//		)
	private Customer customer;
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name ="order_products",
							column = @Column(name="inShoppingCartProduct"))
	})
	//@OneToOne(cascade = CascadeType.ALL)
	private ShoppingCart shoppingCart;
	
	
	//@ElementCollection
	//private List<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();
	
	public Order() {
	
	}

	public Order(Customer customer, ShoppingCart shoppingCart) {
		this.customer = customer;
		this.shoppingCart = shoppingCart;
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
