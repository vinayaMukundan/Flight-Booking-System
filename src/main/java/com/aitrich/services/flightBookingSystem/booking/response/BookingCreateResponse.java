package com.aitrich.services.flightBookingSystem.booking.response;

import java.util.Set;

import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;

public class BookingCreateResponse {
	
	private String id;
	private Passenger passenger;
	private Set<Flight> flights;
	public BookingCreateResponse(String id, Passenger passenger, Set<Flight> flights) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.flights = flights;
	}
	public BookingCreateResponse() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Set<Flight> getFlights() {
		return flights;
	}
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	@Override
	public String toString() {
		return "BookingCreateResponse [id=" + id + ", passenger=" + passenger + ", flights=" + flights + "]";
	}

}
