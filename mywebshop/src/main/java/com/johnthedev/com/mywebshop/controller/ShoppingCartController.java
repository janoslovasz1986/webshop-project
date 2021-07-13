package com.johnthedev.com.mywebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnthedev.com.mywebshop.dto.ProductDto;
import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;
import com.johnthedev.com.mywebshop.entity.ShoppingCartItem;
import com.johnthedev.com.mywebshop.mapper.ProductDtoMapper;
import com.johnthedev.com.mywebshop.service.ProductService;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

	private ProductService productService;

	@Autowired
	public ShoppingCartController(ProductService theProductService) {

		productService = theProductService;

	}
	
	@Autowired
	public ProductDtoMapper productDtoMapper;
	
	@Autowired
	public ShoppingCart theShoppingCart;

	
	@GetMapping("/addProductToShoppingCart")
	public String addProductToShoppingCart(@RequestParam("productId") int theId, Model theModel) {

		ProductDto tempProductDto = productDtoMapper.productEntityToProductDtoMapper(productService.findById(theId));

		int tempProductQuantity = 1;

		ShoppingCartItem tempShoppingCartItem = new ShoppingCartItem(tempProductDto, tempProductQuantity);
		
		theShoppingCart.addProduct(tempShoppingCartItem);

		theModel.addAttribute("shoppingCart", theShoppingCart);
		
		return "redirect:/products/list";
	}

	

	@GetMapping("/list")
	public String listShoppingCart(Model theModel) {

		theModel.addAttribute("shoppingCart", theShoppingCart);

		return "shoppingcart/shoppingcart";
	}
	
	
	@GetMapping("/removeShoppingCartProduct")
	public String removeShoppingCartProduct(@RequestParam("productId") int theId, Model theModel) {
		
		ProductDto tempProduct = productDtoMapper.productEntityToProductDtoMapper(productService.findById(theId));

		int tempProductQuantity = 1;

		ShoppingCartItem tempShoppingCartItem = new ShoppingCartItem(tempProduct, tempProductQuantity);
		
		theShoppingCart.removeProduct(tempShoppingCartItem);
		
		theModel.addAttribute("shoppingCart", theShoppingCart);
		
		return "shoppingcart/shoppingcart";
	}
	
	
	
	@GetMapping("/removeAllShoppingCartProduct")
	public String removeAllShoppingCartProduct(Model theModel) {
		
		
		theShoppingCart.removeAllProducts();
		
		theModel.addAttribute("shoppingCart", theShoppingCart);
		
		return "shoppingcart/shoppingcart";
	}

}
