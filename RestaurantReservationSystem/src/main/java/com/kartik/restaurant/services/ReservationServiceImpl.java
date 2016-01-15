package com.kartik.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kartik.restaurant.dao.ReservationDAO;
import com.kartik.restaurant.model.Reservation;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationDAO reservationDAO;

	
	@Override
	public List<Reservation> listAllReservations() {
		return reservationDAO.listAllReservations();
	}
	
	@Override
	public Reservation listOneReservation(int confirmationNumber) {
		
		return reservationDAO.listOneReservation(confirmationNumber);
		
	}

	@Override
	public Reservation createNewReservation(Reservation reservation) {
		return reservationDAO.createNewReservation(reservation);
	}

	@Override
	public Reservation updateExistingReservation(Reservation reservation) {
		return reservationDAO.updateExistingReservation(reservation);
	}

	@Override
	public Reservation cancelExistingReservation(int confNo, Reservation reservation) {
		return reservationDAO.cancelExistingReservation(confNo, reservation);
	}

}
