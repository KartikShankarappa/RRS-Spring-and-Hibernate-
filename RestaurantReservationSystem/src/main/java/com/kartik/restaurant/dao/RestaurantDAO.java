package com.kartik.restaurant.dao;

import com.kartik.restaurant.model.Restaurant;

public interface RestaurantDAO {

	public Restaurant findRestaurantDetails();
	public Restaurant updateRestaurantDetails(Restaurant restaurant);
}
