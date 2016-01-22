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
import com.kartik.restaurant.model.Reservation;
import com.kartik.restaurant.services.ReservationService;

@Controller
@RequestMapping("/api/admin/reservations")
public class AdminReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value="/{emailId}/{token}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<List<Reservation>> findAllReservations(@PathVariable("emailId") String emailId, @PathVariable("token") String token) {
		
		List<Reservation> tempReservations = new ArrayList<Reservation>();
		
		if(AdminDAOImpl.isSessionValid(emailId, token)) {
			tempReservations = reservationService.listAllReservations();
			
			if(tempReservations.size() == 0) {
				return new ResponseEntity<List<Reservation>>(tempReservations, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<Reservation>>(tempReservations, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<List<Reservation>>(tempReservations, HttpStatus.UNAUTHORIZED);
		}
		
		
	}
}
