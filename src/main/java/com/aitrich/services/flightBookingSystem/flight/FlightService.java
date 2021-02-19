package com.aitrich.services.flightBookingSystem.flight;

import java.time.LocalDateTime;
import java.util.List;

import com.aitrich.services.flightBookingSystem.domain.entity.Flight;



public interface FlightService {

	Flight getFlightById(String flightId);
	List<Flight> getAllFlights();
	Flight insertFlight(Flight flight);
	Flight updateFlight(Flight flight);
	String deleteFlight(String flightId);
	List<Flight> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate);
	List<Flight> findFlightByAllField(String departure, LocalDateTime departureDate,String arrival,LocalDateTime arrivalDate);
}
