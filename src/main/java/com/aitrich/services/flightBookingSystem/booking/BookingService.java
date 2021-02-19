package com.aitrich.services.flightBookingSystem.booking;

import java.util.List;

import com.aitrich.services.flightBookingSystem.domain.entity.FlightBooking;



public interface BookingService {
	
	FlightBooking insertBooking(FlightBooking model);
	FlightBooking updateBooking(FlightBooking model);

	
	
	FlightBooking getBooking(String bookingId);
	List<FlightBooking> getAllBookingsByPassenger(String passengerId);
	List<FlightBooking> getAllMultiFlightBookingsByPassenger(String passengerId);
	List<FlightBooking> getAllMultiFlightBookings();
	
	String deleteBookingbyFlightid(String flightId);

}
