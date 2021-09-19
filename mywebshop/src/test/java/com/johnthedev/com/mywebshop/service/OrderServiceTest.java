package com.johnthedev.com.mywebshop.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.johnthedev.com.mywebshop.dao.OrderRepository;
import com.johnthedev.com.mywebshop.entity.Customer;
import com.johnthedev.com.mywebshop.entity.Order;
import com.johnthedev.com.mywebshop.entity.OrderStatus;
import com.johnthedev.com.mywebshop.entity.ShoppingCart;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class OrderServiceTest {
	
	@Autowired
	private OrderRepository orderRepository;

	@Test
	void testFindAll() {
		
		orderRepository.deleteAll();
		
		Order order1 = new Order();
//		order1.setCustomer(new Customer("John","Smith","johnsmith@gmail.com"));
		order1.setOrderStatus(OrderStatus.MODIFIABLE);
		order1.setShoppingCart(new ShoppingCart());
		
		Order order2 = new Order();
//		order2.setCustomer(new Customer("Jack","Jones","jackjones@gmail.com"));
		order2.setOrderStatus(OrderStatus.MODIFIABLE);
		order2.setShoppingCart(new ShoppingCart());
		
		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		
		for (Order tempOrder: orders) {
			orderRepository.save(tempOrder);
		}
		
		orders = null;
		orders = orderRepository.findAll();
		
		Assertions.assertThat(orders.size()).isEqualTo(2);
		
	}

	@Test
	void testFindById() {
		
		orderRepository.deleteAll();

		Order order = new Order();
//		order.setCustomer(new Customer("John","Smith","johnsmith@gmail.com"));
		order.setOrderStatus(OrderStatus.MODIFIABLE);
		order.setShoppingCart(new ShoppingCart());
		
		orderRepository.save(order);
		
		Assertions.assertThat(order.getId()).isGreaterThan(0);

	}

	@Test
	void testSaveOrder() {
		Order order = new Order();
//		order.setCustomer(new Customer("John","Smith","johnsmith@gmail.com"));
		order.setOrderStatus(OrderStatus.MODIFIABLE);
		order.setShoppingCart(new ShoppingCart());
		
		orderRepository.save(order);
		
		Assertions.assertThat(order.getId()).isGreaterThan(0);
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");

	}

	@Test
	void testFindLast() {
	orderRepository.deleteAll();
		
		Order order1 = new Order();
//		order1.setCustomer(new Customer("John","Smith","johnsmith@gmail.com"));
		order1.setOrderStatus(OrderStatus.MODIFIABLE);
		order1.setShoppingCart(new ShoppingCart());
		
		Order order2 = new Order();
//		order2.setCustomer(new Customer("Jack","Jones","jackjones@gmail.com"));
		order2.setOrderStatus(OrderStatus.MODIFIABLE);
		order2.setShoppingCart(new ShoppingCart());
		
		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		
		for (Order tempOrder: orders) {
			orderRepository.save(tempOrder);
		}
		
		orders = null;
		orders = orderRepository.findAll();
		
		Assertions.assertThat(orders.get(orders.size()-1).getId()).isGreaterThan(1);
	}

}
