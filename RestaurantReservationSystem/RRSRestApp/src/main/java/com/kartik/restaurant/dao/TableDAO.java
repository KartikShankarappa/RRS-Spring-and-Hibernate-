package com.kartik.restaurant.dao;

import com.kartik.restaurant.model.Reservation;

public interface TableDAO {
	
	public int findTable(Reservation reservation);
	public boolean ifCurrentTableStillOk(Reservation reservation);
	

}
