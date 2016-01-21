package com.kartik.restaurant.dao;

import java.util.List;

import com.kartik.restaurant.model.Customer;

public interface CustomerDAO {

	public List<Customer> listAllCustomers();
	public boolean addCustomer(Customer customer);
}
