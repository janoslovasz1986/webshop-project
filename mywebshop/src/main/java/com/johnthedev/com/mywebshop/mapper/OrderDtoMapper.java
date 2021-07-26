package com.johnthedev.com.mywebshop.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnthedev.com.mywebshop.dto.OrderDto;
import com.johnthedev.com.mywebshop.entity.Order;

//@Component
public class OrderDtoMapper {

	@Autowired
	public OrderDto theOrderDto;
	
	@Autowired
	public Order theOrder;

	public OrderDto orderEntityToOrderDtoMapper(Order theOrder) {

		theOrderDto = new OrderDto();

		theOrderDto.setId(theOrder.getId());
		theOrderDto.setCustomer(theOrder.getCustomer());
		theOrderDto.setShoppingCart(theOrder.getShoppingCart());

		return theOrderDto;
	}

	public List<OrderDto> orderEntityListToOrderDtoListMapper(List<Order> theOrders) {

		return theOrders.stream()
				.map(x -> orderEntityToOrderDtoMapper(x))
				.collect(Collectors.toList());

	}

	public Order orderDtoToOrderEntityMapper(OrderDto theOrderDto) {
		
		theOrder = new Order();

		theOrder.setId(theOrderDto.getId());
		theOrder.setCustomer(theOrderDto.getCustomer());
		theOrder.setShoppingCart(theOrderDto.getShoppingCart());
		
		return theOrder;
	}

	public List<Order> orderDtoToListOrderEntityListMapper(List<OrderDto> theOrders) {

		return theOrders.stream().map(x -> orderDtoToOrderEntityMapper(x)).collect(Collectors.toList());

	}

}
