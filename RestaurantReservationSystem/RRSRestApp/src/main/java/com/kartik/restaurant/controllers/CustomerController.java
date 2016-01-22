package com.kartik.restaurant.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kartik.restaurant.dao.AdminDAOImpl;
import com.kartik.restaurant.model.Customer;
import com.kartik.restaurant.services.CustomerService;

@Controller
@RequestMapping("/api/customer_database")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/{emailId}/{token}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<List<Customer>> findAllCustomers(@PathVariable("emailId") String emailId, @PathVariable("token") String token) {
		
		List<Customer> tempCustomers = new ArrayList<Customer>();
		
		if(AdminDAOImpl.isSessionValid(emailId, token)) {
			tempCustomers = customerService.listAllCustomers();
			if(tempCustomers.size() == 0) {
				return new ResponseEntity<List<Customer>>(tempCustomers, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<Customer>>(tempCustomers, HttpStatus.OK);
			}
		} else {
			
			return new ResponseEntity<List<Customer>>(tempCustomers, HttpStatus.UNAUTHORIZED);
		}
		
		
	}
	
}
