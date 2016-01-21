package com.kartik.restaurant.services;

import java.util.List;

import com.kartik.restaurant.model.Reservation;

public interface ReservationService {

	public List<Reservation> listAllReservations();
	public Reservation listOneReservation(int confirmationNumber);
	public Reservation createNewReservation(Reservation reservation);
	public Reservation updateExistingReservation(Reservation reservation);
	public Reservation cancelExistingReservation(int confNo, Reservation reservation);
		
}
