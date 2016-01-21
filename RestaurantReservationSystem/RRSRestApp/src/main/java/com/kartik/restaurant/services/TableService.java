package com.kartik.restaurant.services;

import java.util.List;

import com.kartik.restaurant.model.Reservation;
import com.kartik.restaurant.model.ReservationTable;

public interface TableService {
	
	public int findTable(Reservation reservation);
	public List<ReservationTable> findAllTables();
	public boolean ifCurrentTableStillOk(Reservation reservation);

}
