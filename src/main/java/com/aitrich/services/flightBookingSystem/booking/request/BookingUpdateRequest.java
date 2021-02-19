package com.aitrich.services.flightBookingSystem.booking.request;

import java.util.List;

import javax.persistence.Id;

import com.aitrich.services.flightBookingSystem.flight.request.FlightCreateRequest;

public class BookingUpdateRequest {
	@Id
	private String bookingId;
	private String passengerId;
	private List<FlightCreateRequest> flights;
	public BookingUpdateRequest(String bookingId, String passengerId, List<FlightCreateRequest> flights) {
		super();
		this.bookingId = bookingId;
		this.passengerId = passengerId;
		this.flights = flights;
	}
	public BookingUpdateRequest() {
		super();
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public List<FlightCreateRequest> getFlights() {
		return flights;
	}
	public void setFlights(List<FlightCreateRequest> flights) {
		this.flights = flights;
	}
	@Override
	public String toString() {
		return "BookingUpdateRequest [bookingId=" + bookingId + ", passengerId=" + passengerId + ", flights=" + flights
				+ "]";
	}
}
