package com.johnthedev.com.mywebshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private double productPrice;
	
	@Column(name="discount")
	private double discount;
	
	@Column(name="in_stock_quantity")
	private int inStockQuantity;
	
	@Column(name="image_path")
	private String imgPath;
	
	public Product() {
		
	}

	public Product(String productName, double productPrice, double discount) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.discount = discount;
	}

	public Product(int id, String productName, double productPrice, double discount) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.discount = discount;
	}
	

	public Product(String productName, double productPrice, double discount, int inStockQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.discount = discount;
		this.inStockQuantity = inStockQuantity;
	}

	
	public Product(int id, String productName, double productPrice, double discount, int inStockQuantity,
			String imgPath) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.discount = discount;
		this.inStockQuantity = inStockQuantity;
		this.imgPath = imgPath;
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
	

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice + ", discount="
				+ discount + ", inStockQuantity=" + inStockQuantity + ", imgPath=" + imgPath + "]";
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
		Product other = (Product) obj;
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
	
	

}
