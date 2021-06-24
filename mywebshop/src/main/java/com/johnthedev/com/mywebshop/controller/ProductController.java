package com.johnthedev.com.mywebshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnthedev.com.mywebshop.entity.Product;
import com.johnthedev.com.mywebshop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService theProductService) {
		
		productService = theProductService;
	
	}
	
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		List<Product> theProducts = productService.findAll();
		
		theModel.addAttribute("products", theProducts);
		
		return "products/list-products";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "products/product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		
		productService.save(theProduct);
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {
		
		Product theProduct = productService.findById(theId);
		
		theModel.addAttribute("product",theProduct);
		
		return "products/product-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		productService.deleteById(theId);
		
		return "redirect:/products/list";
	}
}
