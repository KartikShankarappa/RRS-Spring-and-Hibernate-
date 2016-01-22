package com.kartik.restaurant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kartik.restaurant.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listAllCustomers() {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer");
		
		List<Customer> customers = (List<Customer>) query.list();
		
		return customers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query1 = session.createQuery("from Customer where emailId = :param1");
		query1.setString("param1", customer.getEmailId());
		
		List<Customer> customers = (List<Customer>) query1.list();
		System.out.println("The customer list is: " + customers);
		System.out.println("The customer list size is: " + customers.size());
		
		if(customers.size() == 0) {
			session = sessionFactory.getCurrentSession();
			session.save(customer);
			return true;	
		} else {
			return false;
		}
		
	}

}
