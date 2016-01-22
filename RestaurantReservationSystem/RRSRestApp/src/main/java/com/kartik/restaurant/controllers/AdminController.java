package com.kartik.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kartik.restaurant.model.Admin;
import com.kartik.restaurant.services.AdminService;

@Controller
@RequestMapping("/api/authentication")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Admin> login(@RequestBody Admin loginDetails) {
		
		Admin admin = new Admin();
		
		admin = adminService.authenticateUser(loginDetails);
		
		if(admin.getToken() == null) {
			return new ResponseEntity<Admin>(admin, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		}
		
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public ResponseEntity<Admin> logout(@RequestBody Admin loginDetails) {
		
		
		Admin admin = new Admin();
		
		admin = adminService.logout(loginDetails);
		
		if(admin == null) {
			return new ResponseEntity<Admin>(admin, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		}
	}
	
	
	
}
