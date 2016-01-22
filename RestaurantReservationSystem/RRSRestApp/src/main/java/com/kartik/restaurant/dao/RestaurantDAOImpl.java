package com.kartik.restaurant.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kartik.restaurant.model.Restaurant;

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Restaurant findRestaurantDetails() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Restaurant restaurant = (Restaurant) session.get(Restaurant.class, "1");
		return restaurant;
	}

	@Override
	public Restaurant updateRestaurantDetails(Restaurant restaurant) {

		int temp = 0;
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("UPDATE Restaurant set restaurantName = :param1, emailId = :param2, address = :param3,  city = :param4, state = :param5, zip = :param6, phoneNumber = :param7, daysOfOperation = :param8, openingTime = :param9, closingTime = :param10 where restaurantId = 1");
		
		query.setString("param1", restaurant.getRestaurantName());
		query.setString("param2", restaurant.getEmailId());
		query.setString("param3", restaurant.getAddress());
		query.setString("param4", restaurant.getCity());
		query.setString("param5", restaurant.getState());
		query.setInteger("param6", restaurant.getZip());
		query.setString("param7", restaurant.getPhoneNumber());
		query.setString("param8", restaurant.getDaysOfOperation());
		query.setString("param9", restaurant.getOpeningTime());
		query.setString("param10", restaurant.getClosingTime());
		
		temp = query.executeUpdate();
		
		if(temp == 0) {
			return null;
		} else {
			return (Restaurant) sessionFactory.getCurrentSession().get(Restaurant.class, "1");
		}
		
	}

}
