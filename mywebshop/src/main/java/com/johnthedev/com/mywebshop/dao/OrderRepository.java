package com.johnthedev.com.mywebshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnthedev.com.mywebshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
