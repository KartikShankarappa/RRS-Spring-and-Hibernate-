package com.kartik.restaurant.services;

import com.kartik.restaurant.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant findRestaurantDetails();
	public Restaurant updateRestaurantDetails(Restaurant restaurant);

}
