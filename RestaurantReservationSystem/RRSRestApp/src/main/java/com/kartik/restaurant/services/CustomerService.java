package com.kartik.restaurant.services;

import java.util.List;

import com.kartik.restaurant.model.Customer;

public interface CustomerService {
	
	public List<Customer> listAllCustomers();
	public boolean addCustomer(Customer customer);

}
