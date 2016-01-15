package com.kartik.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reservationtable")
public class ReservationTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tableNumber")
	private int tableNumber;
	
	@Column(name="maxOccupancy")
	private int maxOccupancy;
	
	@Column(name="availability")
	private boolean availability;
	
	
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public int getMaxOccupancy() {
		return maxOccupancy;
	}
	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
}

