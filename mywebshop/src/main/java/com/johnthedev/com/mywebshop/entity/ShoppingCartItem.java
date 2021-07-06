package com.johnthedev.com.mywebshop.entity;

import javax.persistence.Embeddable;

@Embeddable
public class ShoppingCartItem {

	private Product inShoppingCartProduct;
	private int inShoppingCartProductQuantity;
	
	public ShoppingCartItem() {		
	}

	public ShoppingCartItem(Product inShoppingCartProduct, int inShoppingCartProductQuantity) {
		this.inShoppingCartProduct = inShoppingCartProduct;
		this.inShoppingCartProductQuantity = inShoppingCartProductQuantity;
	}

	public Product getInShoppingCartProduct() {
		return inShoppingCartProduct;
	}

	public void setInshoppingCartProduct(Product inShoppingCartProduct) {
		this.inShoppingCartProduct = inShoppingCartProduct;
	}

	public int getInShoppingCartProductQuantity() {
		return inShoppingCartProductQuantity;
	}

	public void setInShoppingCartProductQuantity(int inShoppingCartProductQuantity) {
		this.inShoppingCartProductQuantity = inShoppingCartProductQuantity;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [inShoppingCartProduct=" + inShoppingCartProduct + ", inShoppingCartProductQuantity="
				+ inShoppingCartProductQuantity + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inShoppingCartProduct == null) ? 0 : inShoppingCartProduct.hashCode());
		result = prime * result + inShoppingCartProductQuantity;
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
		ShoppingCartItem other = (ShoppingCartItem) obj;
		if (inShoppingCartProduct == null) {
			if (other.inShoppingCartProduct != null)
				return false;
		} else if (!inShoppingCartProduct.equals(other.inShoppingCartProduct))
			return false;
		if (inShoppingCartProductQuantity != other.inShoppingCartProductQuantity)
			return false;
		return true;
	}

	public double getAmount() {
		
		return this.inShoppingCartProduct.getProductPrice() * this.inShoppingCartProductQuantity;
		
	}
	
}
