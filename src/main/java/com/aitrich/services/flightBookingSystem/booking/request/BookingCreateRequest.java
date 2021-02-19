package com.aitrich.services.flightBookingSystem.booking.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.flight.request.FlightCreateRequest;



public class BookingCreateRequest {
	
private String id;
	
	@Valid
	@NotNull
	private String passengerId;
	@NotNull
	private String arrival;
	
	private String arrivalDate;
	private String departure;
	private String departureDate;
	public BookingCreateRequest(String id, @Valid @NotNull String passengerId, @NotNull String arrival,
			String arrivalDate, String departure, String departureDate) {
		super();
		this.id = id;
		this.passengerId = passengerId;
		this.arrival = arrival;
		this.arrivalDate = arrivalDate;
		this.departure = departure;
		this.departureDate = departureDate;
	}
	public BookingCreateRequest() {
		super();
	}
	
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	@Override
	public String toString() {
		return "BookingCreateRequest [passengerId=" + passengerId + ", arrival=" + arrival + ", arrivalDate="
				+ arrivalDate + ", departure=" + departure + ", departureDate=" + departureDate + "]";
	}
	
	
	
}
