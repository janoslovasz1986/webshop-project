package com.johnthedev.com.mywebshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.johnthedev.com.mywebshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value= "select s from Products s where s.product_name like :searchName", nativeQuery = true)
	public List<Product> findByProductNameLike(String searchName);

}
