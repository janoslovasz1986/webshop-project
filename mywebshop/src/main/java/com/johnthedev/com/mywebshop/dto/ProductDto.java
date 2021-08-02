package com.johnthedev.com.mywebshop.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductDto {
	
	@Column(name="product_id")
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	private double productPrice;
	private double discount;
	
	@Column(name="in_stock_quantity")
	private int inStockQuantity;
	
	public ProductDto() {
	}

	public ProductDto(int id, String productName, double productPrice, double discount) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.discount = discount;
	}
	
	public ProductDto(int id, String productName, double productPrice, double discount, int inStockQuantity) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.discount = discount;
		this.inStockQuantity = inStockQuantity;
	}

	public ProductDto(String productName, double productPrice, double discount) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	

	public int getInStockQuantity() {
		return inStockQuantity;
	}

	public void setInStockQuantity(int inStockQuantity) {
		this.inStockQuantity = inStockQuantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ProductDto other = (ProductDto) obj;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (id != other.id)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", discount=" + discount + "]";
	}
	
	
	
	
	
	
	

}
