package com.aitrich.services.flightBookingSystem.airport;

import com.aitrich.services.flightBookingSystem.exception.ResourceNotFoundException;

public class AirportNotFoundException extends ResourceNotFoundException{

	private static final long serialVersionUID = -4185306016942664972L;

	public AirportNotFoundException(String airportId) {
		super("Airport", "airport-id", airportId);
	}
}
