package com.johnthedev.com.mywebshop.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.johnthedev.com.mywebshop.dto.CustomerDto;
import com.johnthedev.com.mywebshop.entity.Customer;

//@Component
public class CustomerDtoMapper {

	@Autowired
	public CustomerDto theCustomerDto;
	
	@Autowired
	public Customer theCustomer;

	public CustomerDto customerEntityToCustomerDtoMapper(Customer theCustomer) {

		theCustomerDto = new CustomerDto();

		theCustomerDto.setId(theCustomer.getId());
		theCustomerDto.setFirstName(theCustomer.getFirstName());
		theCustomerDto.setLastName(theCustomer.getLastName());
		theCustomerDto.setEmail(theCustomer.getEmail());

		return theCustomerDto;
	}

	public List<CustomerDto> customerEntityListToCustomerDtoListMapper(List<Customer> theCustomers) {

		return theCustomers.stream()
				.map(x -> customerEntityToCustomerDtoMapper(x))
				.collect(Collectors.toList());

	}

	public Customer customerDtoToCustomerEntityMapper(CustomerDto theCustomerDto) {
		
		theCustomer = new Customer();

		theCustomer.setId(theCustomerDto.getId());
		theCustomer.setFirstName(theCustomerDto.getFirstName());
		theCustomer.setLastName(theCustomerDto.getLastName());
		theCustomer.setEmail(theCustomerDto.getEmail());

		return theCustomer;
	}

	public List<Customer> customerDtoToListCustomerEntityListMapper(List<CustomerDto> theCustomers) {

		return theCustomers.stream().map(x -> customerDtoToCustomerEntityMapper(x)).collect(Collectors.toList());

	}

}
