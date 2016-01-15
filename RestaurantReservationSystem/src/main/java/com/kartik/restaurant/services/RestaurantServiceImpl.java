package com.kartik.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kartik.restaurant.dao.RestaurantDAO;
import com.kartik.restaurant.model.Restaurant;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;
	
	@Override
	public Restaurant findRestaurantDetails() {
		return restaurantDAO.findRestaurantDetails();
	}

	@Override
	public Restaurant updateRestaurantDetails(Restaurant restaurant) {
		return restaurantDAO.updateRestaurantDetails(restaurant);
	}

}
