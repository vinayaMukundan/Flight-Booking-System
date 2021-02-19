package com.aitrich.services.flightBookingSystem.flight;

import com.aitrich.services.flightBookingSystem.exception.ResourceNotFoundException;

public class FlightNotFoundException extends ResourceNotFoundException{

	
	private static final long serialVersionUID = 6293499259584600291L;

	public FlightNotFoundException(String flightId) {
		super("Flight", "flight-id", flightId);
	}
	
}
