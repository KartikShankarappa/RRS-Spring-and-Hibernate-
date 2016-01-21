package com.kartik.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kartik.restaurant.dao.AdminDAOImpl;
import com.kartik.restaurant.model.Restaurant;
import com.kartik.restaurant.services.RestaurantService;

@Controller
@RequestMapping("/api/profile")
public class RestaurantController {
	
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value="/{emailId}/{token}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<Restaurant> restaurantDetails(@PathVariable("emailId") String emailId, @PathVariable("token") String token) {
		
		Restaurant tempRestaurant = new Restaurant();
		
		if(AdminDAOImpl.isSessionValid(emailId, token)) {
			tempRestaurant = restaurantService.findRestaurantDetails();
			if(tempRestaurant == null) {
				return new ResponseEntity<Restaurant>(tempRestaurant, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<Restaurant>(tempRestaurant, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Restaurant>(tempRestaurant, HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	
	@RequestMapping(value="/{emailId}/{token}", method=RequestMethod.PUT, consumes = "application/json", produces="application/json")
	public ResponseEntity<Restaurant> editRestaurantDetails(@RequestBody Restaurant restaurant, @PathVariable("emailId") String emailId, @PathVariable("token") String token) {
		
		Restaurant tempRestaurant = new Restaurant();
		
		if(AdminDAOImpl.isSessionValid(emailId, token)) {
			tempRestaurant = restaurantService.updateRestaurantDetails(restaurant);
			
			if(tempRestaurant == null) {
				return new ResponseEntity<Restaurant>(tempRestaurant, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<Restaurant>(tempRestaurant, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<Restaurant>(tempRestaurant, HttpStatus.UNAUTHORIZED);
		}
	}

}
