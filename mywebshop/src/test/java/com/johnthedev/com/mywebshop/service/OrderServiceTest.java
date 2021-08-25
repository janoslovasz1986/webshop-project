package com.johnthedev.com.mywebshop.service;

import static org.junit.jupiter.api.Assertions.fail;

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
		
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveOrder() {
		Order order = new Order();
		order.setCustomer(new Customer("John","Smith","johnsmith@gmail.com"));
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
		fail("Not yet implemented");
	}

}
