package com.johnthedev.com.mywebshop.mapper;

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

		theProductDto = new ProductDto();

		theProductDto.setId(theProduct.getId());
		theProductDto.setProductName(theProduct.getProductName());
		theProductDto.setProductPrice(theProduct.getProductPrice());
		theProductDto.setDiscount(theProduct.getDiscount());
		theProductDto.setInStockQuantity(theProduct.getInStockQuantity());
		theProductDto.setImgPath(theProduct.getImgPath());

		return theProductDto;
	}

	public List<ProductDto> productEntityListToProductDtoListMapper(List<Product> theProducts) {

		return theProducts.stream()
				.map(x -> productEntityToProductDtoMapper(x))
				.collect(Collectors.toList());

	}

	public Product producDtoToProductEntityMapper(ProductDto theProductDto) {
		
		theProduct = new Product();

		theProduct.setId(theProductDto.getId());
		theProduct.setProductName(theProductDto.getProductName());
		theProduct.setProductPrice(theProductDto.getProductPrice());
		theProduct.setDiscount(theProductDto.getDiscount());
		theProduct.setInStockQuantity(theProductDto.getInStockQuantity());
		theProduct.setImgPath(theProductDto.getImgPath());

		return theProduct;
	}

	public List<Product> producDtoToListProductEntityListMapper(List<ProductDto> theProductDtos) {

		return theProductDtos.stream().map(x -> producDtoToProductEntityMapper(x)).collect(Collectors.toList());

	}

}
