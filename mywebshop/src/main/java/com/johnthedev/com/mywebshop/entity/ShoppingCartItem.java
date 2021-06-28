package com.johnthedev.com.mywebshop.entity;

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
	
	public double getAmount() {
		
		return this.inShoppingCartProduct.getProductPrice() * this.inShoppingCartProductQuantity;
		
	}
	
}
