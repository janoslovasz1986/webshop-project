package com.johnthedev.com.mywebshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.johnthedev.com.mywebshop.entity.Product;

//@EnableJpaRepositories
//@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value= "SELECT * from Product p WHERE p.product_name LIKE %:searchName%", nativeQuery = true)
	public List<Product> findByProductNameLike(@Param("searchName") String searchName);
	

}
