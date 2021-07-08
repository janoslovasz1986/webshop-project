package com.johnthedev.com.mywebshop.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.johnthedev.com.mywebshop.dto.ProductDto;
import com.johnthedev.com.mywebshop.entity.Product;

public class ProductDtoMapper {
	
	@Autowired
	public Product theProduct;
	
	@Autowired
	public ProductDto theProductDto;
	
	
	public ProductDto ProductEntityToProductDtoMapper(Product theProduct) {
		
		theProductDto.setId(theProduct.getId());
		theProductDto.setProductName(theProduct.getProductName());
		theProductDto.setProductPrice(theProduct.getProductPrice());
		theProductDto.setDiscount(theProduct.getDiscount());
		
		return theProductDto;
	}
	
	public Product ProducDtoToProductEntityMapper(ProductDto theProductDto) {
		
		theProduct.setId(theProductDto.getId());
		theProduct.setProductName(theProductDto.getProductName());
		theProduct.setProductPrice(theProductDto.getProductPrice());
		theProduct.setDiscount(theProductDto.getDiscount());
		
		return theProduct;
	}

}
