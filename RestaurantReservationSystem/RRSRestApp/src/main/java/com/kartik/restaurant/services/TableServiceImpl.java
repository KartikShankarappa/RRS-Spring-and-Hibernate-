package com.kartik.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kartik.restaurant.dao.TableDAO;
import com.kartik.restaurant.model.Reservation;
import com.kartik.restaurant.model.ReservationTable;

@Service("ReservationTableServiceAnnotation")
@Transactional
public class TableServiceImpl implements TableService{

	
	@Autowired
	TableDAO tableDAO;
	
	@Override
	public int findTable(Reservation reservation){
		
		return tableDAO.findTable(reservation);
		
	}
	
	@Override
	public List<ReservationTable> findAllTables() {
		
		return null;
	}
	
	@Override
	public boolean ifCurrentTableStillOk(Reservation reservation) {
		
		return tableDAO.ifCurrentTableStillOk(reservation);
		
	}
}
