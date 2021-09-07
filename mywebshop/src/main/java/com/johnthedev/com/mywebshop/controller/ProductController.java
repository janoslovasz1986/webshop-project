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

import com.johnthedev.com.mywebshop.configuration.security.UserService;
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
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		//User user = userService.findUserByUserName(auth.getName());
		
		List<ProductDto> theProducts = productDtoMapper.productEntityListToProductDtoListMapper(productService.findAll());
		
		theModel.addAttribute("products", theProducts);
//		if (user != null) {
//			theModel.addAttribute("user", user); 
//			user.setHasAdminRole(user.isHasAdminRole());
//			System.out.println(user.isHasAdminRole());
//
//		}
		
		return "products/list-products";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Product theProduct = new Product();
		String s = new String();
		
		if (theModel.getAttribute("imgPath") != null) {
		
			s = theModel.getAttribute("imgPath").toString();

			theProduct.setImgPath(s);
			theModel.addAttribute("imgPath", s);
		}
		theModel.addAttribute("imgPath", s);
		theModel.addAttribute("product", theProduct);
//		redirectAttributes.addFlashAttribute("imgPath", s);
		return "products/product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") ProductDto theProduct,Model theModel, 
								@ModelAttribute("imgPath") String imgPath) {
		
		Product product = new Product();
		System.out.println("Model before save psots:  " + theModel);
		
		product = productDtoMapper.producDtoToProductEntityMapper(theProduct);
		product.setImgPath(theModel.getAttribute("imgPath").toString());
		System.out.println("Model after update save psots:  " + theModel);
		
//		if (imagePath != null) {
//			product.setImgPath(theModel.getAttribute("imagePath").toString());
//			System.out.println("*****************************-");
//			System.out.println("*** the path is: "+ theModel.getAttribute("imagePath").toString());
//			System.out.println("*** the path is: "+ theModel.getAttribute("imgPath").toString());
//		}
		
		productService.save(product);
		
		return "redirect:/products/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {
		
		System.out.println("model in update : " + theModel);
		ProductDto theProduct = productDtoMapper.productEntityToProductDtoMapper(productService.findById(theId));
		
//		theModel.addAttribute("product",theProduct);
		
		if (theModel.containsAttribute("imgPath")) {
			System.out.println("YUP--------: " + theModel.getAttribute("imgPath"));
			theModel.addAttribute("imagePath",theModel.getAttribute("imgPath"));
			theProduct.setImgPath(theModel.getAttribute("imgPath").toString());
		}
		
		theModel.addAttribute("product",theProduct);
		System.out.println("model in update end : " + theModel);
		return "products/product-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		productService.deleteById(theId);
		
		return "redirect:/products/list";
	}
	
    @GetMapping("/search")
    public String searchProducts(@RequestParam(name = "theSearchName" , required = false) String theSearchName,
                                    Model theModel) {
        List<Product> theProducts = productService.searchProducts(theSearchName);
                
        theModel.addAttribute("products", theProducts);
        return "products/list-products"; 
    }
    
    @GetMapping("/test")
    public String testProducts( Model theModel) {

        return "products/test"; 
    }
}
