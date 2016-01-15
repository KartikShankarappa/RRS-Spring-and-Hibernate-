package com.kartik.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kartik.restaurant.model.Reservation;
import com.kartik.restaurant.services.ReservationService;
import com.kartik.restaurant.services.TableService;


@Controller
@RequestMapping("/api/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private TableService tableService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Reservation> findOneReservation(@PathVariable("id") int id) {
		
		Reservation tempReservation = new Reservation();
		
		tempReservation = reservationService.listOneReservation(id);
		
		if(tempReservation == null) {
			return new ResponseEntity<Reservation>(tempReservation, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Reservation>(tempReservation, HttpStatus.OK);
		}
			
	}
	
	@RequestMapping(value="/makeReservation", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
		
		Reservation tempReservation = new Reservation();
		int tableNo = tableService.findTable(reservation);
		
		if(tableNo != -1) {
			reservation.setTableNumber(tableNo);
			reservation.setReservationStatus("CONFIRMED");
		} else {
			reservation.setReservationStatus("WAITING");
		}
		
		tempReservation = reservationService.createNewReservation(reservation);
		
		if(tempReservation == null) {
			return new ResponseEntity<Reservation>(tempReservation, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Reservation>(tempReservation, HttpStatus.OK);
		}
		
	}
	
	
	@RequestMapping(value="/updateReservation", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
		
		Reservation tempReservation = new Reservation();
		int tableNo = -1;
		
		if(!tableService.ifCurrentTableStillOk(reservation)) {
			tableNo = tableService.findTable(reservation);
			
			if(tableNo != -1) {
				reservation.setTableNumber(tableNo);
				reservation.setReservationStatus("CONFIRMED");
			} else {
				reservation.setTableNumber(0);
				reservation.setReservationStatus("WAITING");
			}
			
		}
		
		tempReservation = reservationService.updateExistingReservation(reservation);
		
		if(tempReservation == null) {
			return new ResponseEntity<Reservation>(tempReservation, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Reservation>(tempReservation, HttpStatus.OK);
		}
		
	}
	
	
	@RequestMapping(value="/cancelReservation/{id}", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable ("id") int confNo, @RequestBody Reservation reservation) {
		
		Reservation tempReservation = new Reservation();
		
		reservation.setReservationStatus("CANCELLED");
		
		tempReservation = reservationService.cancelExistingReservation(confNo, reservation);
		
		if(tempReservation == null) {
			return new ResponseEntity<Reservation>(tempReservation, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Reservation>(tempReservation, HttpStatus.OK);
		}
	}
	

}
