package com.johnthedev.com.mywebshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
public class ShoppingCart{
	
	
	@ElementCollection
	@CollectionTable(name = "list_of_shoppingcart_products" , joinColumns =  @JoinColumn(name= "order_id"))
	private List<ShoppingCartItem> listOfShoppingCartProducts = new ArrayList<ShoppingCartItem>();

	public ShoppingCart() {

	}


	public ShoppingCart(List<ShoppingCartItem> listOfShoppingCartProducts) {
		this.listOfShoppingCartProducts = listOfShoppingCartProducts;
	}


	public List<ShoppingCartItem> getListOfShoppingCartProducts() {
		return listOfShoppingCartProducts;
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


	@Override
	public String toString() {
		return "ShoppingCart [listOfShoppingCartProducts=" + listOfShoppingCartProducts + "]";
	}


	public void setListOfShoppingCartProducts(List<ShoppingCartItem> listOfShoppingCartProducts) {
		this.listOfShoppingCartProducts = listOfShoppingCartProducts;
	}



	public void addProduct(ShoppingCartItem shoppingCartItem) {

		if (listOfShoppingCartProducts.isEmpty()) {

			listOfShoppingCartProducts.add(shoppingCartItem);

		} else {

			int size = listOfShoppingCartProducts.size();

			boolean isNewItem = false;

			for (int i = 0; i < size; i++) {
				isNewItem = false;

				if (listOfShoppingCartProducts.get(i).getInShoppingCartProduct().getId() != shoppingCartItem
						.getInShoppingCartProduct().getId()) {

					isNewItem = true;
				} else {
					listOfShoppingCartProducts.get(i).setInShoppingCartProductQuantity(
							listOfShoppingCartProducts.get(i).getInShoppingCartProductQuantity() + 1);
					break;
				}
			}

			if (isNewItem) {
				listOfShoppingCartProducts.add(shoppingCartItem);
			}
		}
	}

	public void removeProduct(ShoppingCartItem shoppingCartItem) {

		for (ShoppingCartItem theShoppingCartItem : listOfShoppingCartProducts) {

			if (theShoppingCartItem.getInShoppingCartProduct().getId() == shoppingCartItem.getInShoppingCartProduct()
					.getId()) {

				if (theShoppingCartItem.getInShoppingCartProductQuantity() > 1) {
					theShoppingCartItem.setInShoppingCartProductQuantity(
							
							theShoppingCartItem.getInShoppingCartProductQuantity() - 1);
				} else {

					listOfShoppingCartProducts.remove(theShoppingCartItem);
					break;
				}
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
}
