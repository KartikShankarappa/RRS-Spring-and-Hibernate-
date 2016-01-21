package com.kartik.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="restaurantId")
	private String restaurantId;
	
	@Column(name="restaurantName")
	private String restaurantName;
	
	@Column(name="emailId")
	private String emailId;
		
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
	private int zip;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="daysOfOperation")
	private String daysOfOperation;
	
	@Column(name="openingTime")
	private String openingTime;
	
	@Column(name="closingTime")
	private String closingTime;
	
	
	
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDaysOfOperation() {
		return daysOfOperation;
	}
	public void setDaysOfOperation(String daysOfOperation) {
		this.daysOfOperation = daysOfOperation;
	}
	public String getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}
	public String getClosingTime() {
		return closingTime;
	}
	public void setClosingtime(String closingTime) {
		this.closingTime = closingTime;
	}
	
	
	
}

