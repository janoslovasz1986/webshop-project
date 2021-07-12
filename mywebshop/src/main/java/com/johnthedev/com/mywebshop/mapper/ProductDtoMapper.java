package com.johnthedev.com.mywebshop.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnthedev.com.mywebshop.dto.ProductDto;
import com.johnthedev.com.mywebshop.entity.Product;

//@Component
public class ProductDtoMapper {

	@Autowired
	public Product theProduct;

	@Autowired
	public ProductDto theProductDto;

	public ProductDto productEntityToProductDtoMapper(Product theProduct) {

		theProductDto.setId(theProduct.getId());
		theProductDto.setProductName(theProduct.getProductName());
		theProductDto.setProductPrice(theProduct.getProductPrice());
		theProductDto.setDiscount(theProduct.getDiscount());

		return theProductDto;
	}

	public List<ProductDto> productEntityListToProductDtoListMapper(List<Product> theProducts) {
		
		System.out.println("***" + theProducts + "****");

		//return theProducts.stream()
		//		.map(x -> productEntityToProductDtoMapper(x))
		//		.collect(Collectors.toList());
		
		List<ProductDto> tempDtoList = new ArrayList<ProductDto>();
		
		for(int i=0; i<theProducts.size(); i++) {
			
			System.out.println("for "+ i +". cuklus: ");
			
			ProductDto productDto = null;
			
			productDto = productEntityToProductDtoMapper(theProducts.get(i));
			
			//tempDtoList.add(productDto);
			
			tempDtoList.add(productDto);
			
			System.out.println(tempDtoList);
			
		}
		System.out.println("+++" + tempDtoList + "+++");
		
		return tempDtoList;

		
	}

	public Product producDtoToProductEntityMapper(ProductDto theProductDto) {

		theProduct.setId(theProductDto.getId());
		theProduct.setProductName(theProductDto.getProductName());
		theProduct.setProductPrice(theProductDto.getProductPrice());
		theProduct.setDiscount(theProductDto.getDiscount());

		return theProduct;
	}
	
	public List<Product> producDtoToListProductEntityListMapper(List<ProductDto> theProductDtos) {

		return theProductDtos.stream()
				.map(x -> producDtoToProductEntityMapper(x))
				.collect(Collectors.toList());
						
	}

}
