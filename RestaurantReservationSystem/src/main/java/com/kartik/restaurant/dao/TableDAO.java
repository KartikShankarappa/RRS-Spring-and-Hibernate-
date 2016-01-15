package com.kartik.restaurant.dao;

import java.util.List;

import com.kartik.restaurant.model.Reservation;
import com.kartik.restaurant.model.ReservationTable;

public interface TableDAO {
	
	public int findTable(Reservation reservation);
	public List<ReservationTable> findAllTables();
	public boolean ifCurrentTableStillOk(Reservation reservation);
	

}
