package com.aitrich.services.flightBookingSystem.airport;

import java.util.List;

import com.aitrich.services.flightBookingSystem.domain.entity.Airport;



public interface AirportService {

	Airport getAirportById(String airportId);
	List<Airport> getAllAirports();
	Airport insertAirport(Airport airport);
	Airport updateAirport(Airport airport);
	String deleteAirport(String airportId);
}
