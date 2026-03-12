package com;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bus {
	@Id
	private int id;
	private String busNumber;
	private String fromLocation;
	private String toLocation;
	private int capacity;
	private double ticketPrice;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", busNumber=" + busNumber + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", capacity=" + capacity + ", ticketPrice=" + ticketPrice + "]";
	}
	
	
	
	

}
