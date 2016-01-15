package com.kartik.restaurant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kartik.restaurant.model.Customer;
import com.kartik.restaurant.model.Reservation;

@Repository
public class ReservationDAOImpl implements ReservationDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> listAllReservations() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Reservation");
		List<Reservation> reservations = (List<Reservation>) query.list();
		
		if(reservations.size() == 0) {
			return null;
		} else {
			return reservations;
		}
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Reservation listOneReservation(int confirmationNumber) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Reservation where confirmationNumber = :param1 and reservationStatus IN ('CONFIRMED', 'WAITING')");
		query.setInteger("param1", confirmationNumber);
		
		List<Reservation> reservations = (List<Reservation>) query.list();
//		Reservation reservation = (Reservation) session.get(Reservation.class, confirmationNumber);
		if(reservations.size() == 0) {
			return null;
		} else {
			return reservations.get(0);
		}
	}

	@Override
	public Reservation createNewReservation(Reservation reservation) {
		
		int confirmationNumber = -1;
		Reservation tempReservation = new Reservation();
		Customer customer = new Customer();
		customer.setFname(reservation.getFirstName());
		customer.setLname(reservation.getLastName());
		customer.setEmailId(reservation.getEmailId());
		customer.setPhoneNumber(reservation.getPhoneNumber());
		
		Session session = sessionFactory.getCurrentSession();
		
		confirmationNumber = (int) session.save(reservation);
		
		if(confirmationNumber == -1) {
			return null;
		} else {
			session = sessionFactory.getCurrentSession();
			tempReservation = (Reservation) session.get(Reservation.class, confirmationNumber);
			
			if(customerDAO.addCustomer(customer)){
				System.out.println("Customer Added to the database");
			} else {
				System.out.println("Customer is already present in the database or there is some problem in adding the customer to the database");
			}
			
			return tempReservation;
		}
	}

	@Override
	public Reservation updateExistingReservation(Reservation reservation) {
		
		int temp = -1;
		
		Session session = sessionFactory.getCurrentSession();
		
//		Query query = session.createQuery("UPDATE Reservation RT set RT.tableNumber = :param1 "
//				+ "RT.firstName = :param2, RT.lastName = :param3, RT.emailId = :param4, RT.phoneNumber = :param5 "
//				+ "RT.partySize = :param6, RT.date = :param7, RT.time = :param8, RT.reservationStatus = :param9 "
//				+ "where RT.confirmationNumber = :param10");
		
		Query query = session.createQuery("UPDATE Reservation set tableNumber = :param1, "
				+ "firstName = :param2, lastName = :param3, emailId = :param4, phoneNumber = :param5, "
				+ "partySize = :param6, date = :param7, time = :param8, reservationStatus = :param9 "
				+ "where confirmationNumber = :param10");
		
		query.setInteger("param1", reservation.getTableNumber());
		query.setString("param2", reservation.getFirstName());
		query.setString("param3", reservation.getLastName());
		query.setString("param4", reservation.getEmailId());
		query.setString("param5", reservation.getPhoneNumber());
		query.setInteger("param6", reservation.getPartySize());
		query.setString("param7", reservation.getDate());
		query.setString("param8", reservation.getTime());
		query.setString("param9", reservation.getReservationStatus());
		query.setInteger("param10", reservation.getConfirmationNumber());
		
		temp = query.executeUpdate();
		
		if(temp == -1) {
			return null;
		} else {
			return (Reservation) sessionFactory.getCurrentSession().get(Reservation.class, reservation.getConfirmationNumber());
		}
		
	}

	@Override
	public Reservation cancelExistingReservation(int confNo, Reservation reservation) {
		// TODO Auto-generated method stub
		
		int temp = -1;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("UPDATE Reservation SET reservationStatus = 'CANCELLED'  where confirmationNumber = :param1");
		
		query.setInteger("param1", reservation.getConfirmationNumber());
		
		temp = query.executeUpdate();
		
		if(temp == -1) {
			return null;
		} else {
			return (Reservation) sessionFactory.getCurrentSession().get(Reservation.class, reservation.getConfirmationNumber());
		}
		
	}

}
