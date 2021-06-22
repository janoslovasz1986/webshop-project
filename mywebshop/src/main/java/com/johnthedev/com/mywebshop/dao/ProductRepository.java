package com.johnthedev.com.mywebshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnthedev.com.mywebshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
