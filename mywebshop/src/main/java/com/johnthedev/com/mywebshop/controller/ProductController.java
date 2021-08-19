package com.johnthedev.com.mywebshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnthedev.com.mywebshop.configuration.security.UserService;
import com.johnthedev.com.mywebshop.configuration.security.model.User;
import com.johnthedev.com.mywebshop.dto.ProductDto;
import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.mapper.ProductDtoMapper;
import com.johnthedev.com.mywebshop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService theProductService) {
		
		productService = theProductService;
	
	}
	
	@Autowired
	public ProductDtoMapper productDtoMapper;
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findUserByUserName(auth.getName());
		
		List<ProductDto> theProducts = productDtoMapper.productEntityListToProductDtoListMapper(productService.findAll());
		
		theModel.addAttribute("products", theProducts);
		theModel.addAttribute("userName", user.getName());
		
		
		return "products/list-products";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "products/product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") ProductDto theProduct) {
		
		Product product = new Product();
		
		product = productDtoMapper.producDtoToProductEntityMapper(theProduct);
		
		productService.save(product);
		
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {
		
		ProductDto theProduct = productDtoMapper.productEntityToProductDtoMapper(productService.findById(theId));
		
		theModel.addAttribute("product",theProduct);
		
		return "products/product-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		productService.deleteById(theId);
		
		return "redirect:/products/list";
	}
}
