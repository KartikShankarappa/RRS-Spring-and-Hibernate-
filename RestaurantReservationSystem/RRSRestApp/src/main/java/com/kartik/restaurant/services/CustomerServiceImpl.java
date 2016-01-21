package com.kartik.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kartik.restaurant.dao.CustomerDAO;
import com.kartik.restaurant.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;	
	
	@Override
	public List<Customer> listAllCustomers() {
		return customerDAO.listAllCustomers();
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.addCustomer(customer);
	}
	
	

}
