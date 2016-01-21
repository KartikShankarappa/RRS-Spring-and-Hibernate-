package com.kartik.restaurant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kartik.restaurant.model.Reservation;


@Repository("reservationTableDaoAnnotation")
public class TableDAOImpl implements TableDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public int findTable(Reservation reservation) {
		
		Session session = sessionFactory.getCurrentSession();
		
		int tableNo = -1;
		Query query = session.createQuery("select RT.tableNumber from ReservationTable RT where RT.maxOccupancy >= :param1 and RT.tableNumber NOT IN ( select R.tableNumber from Reservation R where R.date = :param2 and R.time = :param3 and R.reservationStatus = 'CONFIRMED') ");
		
		query.setInteger("param1", reservation.getPartySize());
		query.setString("param2", reservation.getDate());
		query.setString("param3", reservation.getTime());
		
		List<Integer> tables = (List<Integer>) query.list();
		
		if(tables.size() == 0) {
			return tableNo;
		} else {
			System.out.println("Tables is : " + tables);
			tableNo = tables.get(0);
			return tableNo;
		}
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean ifCurrentTableStillOk(Reservation reservation) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select tableNumber from ReservationTable where tableNumber = :param1 and maxOccupancy >= :param2");
		query.setInteger("param1", reservation.getTableNumber());
		query.setInteger("param2", reservation.getPartySize());
		
		List<Integer> tables = (List<Integer>) query.list();
		
		
		if(tables.size() != 0) {
//			query = session.createQuery("select RT.tableNumber, temp.confirmationNumber from ReservationTable RT, (select R.tableNumber, R.confirmationNumber from Reservation R where R.date = :param1 and R.time = :param2 and R.reservationStatus = 'CONFIRMED') as temp where RT.tableNumber = temp.tableNumber and RT.tableNumber = :param3");
			
			query = session.createQuery("select RT.tableNumber, R.confirmationNumber from ReservationTable RT, Reservation R where R.date = :param1 and R.time = :param2 and R.reservationStatus='CONFIRMED' and RT.tableNumber = R.tableNumber and RT.tableNumber = :param3");
			query.setString("param1", reservation.getDate());
			query.setString("param2", reservation.getTime());
			query.setInteger("param3", reservation.getTableNumber());
			
			List<Object[]> temp = (List<Object[]>) query.list();
			
			if (temp.size() != 0) {
				
				Object[] obj = temp.get(0);
				if (reservation.getConfirmationNumber() == (Integer) obj[1]) {
					return true;
				} else {
					return false;
				}
				
			} else {
				return true;
			}
		} else {
			
			return false;
		}
		
	}

}
