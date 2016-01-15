package com.kartik.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="confirmationNumber")
	private int confirmationNumber;
	
	@Column(name="tableNumber")
	private int tableNumber;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="partySize")
	private int partySize;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="reservationStatus")
	private String reservationStatus;
	
	
	public int getConfirmationNumber() {
		return confirmationNumber;
	}
	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPartySize() {
		return partySize;
	}
	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}	
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}	
	
}
