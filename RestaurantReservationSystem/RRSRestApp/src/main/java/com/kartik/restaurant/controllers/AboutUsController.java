package com.kartik.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kartik.restaurant.model.Restaurant;
import com.kartik.restaurant.services.RestaurantService;

@Controller
@RequestMapping("/api/contact_us")
public class AboutUsController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Restaurant> restaurantDetails() {
		
		Restaurant tempRestaurant = new Restaurant();
		
		tempRestaurant = restaurantService.findRestaurantDetails();
		
		if(tempRestaurant == null) {
			return new ResponseEntity<Restaurant>(tempRestaurant, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Restaurant>(tempRestaurant, HttpStatus.OK);
		}

		
	}

}
