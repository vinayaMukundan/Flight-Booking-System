package com.aitrich.services.flightBookingSystem.passenger;

import com.aitrich.services.flightBookingSystem.exception.ResourceNotFoundException;

public class PassengerNotFoundException extends ResourceNotFoundException{

	private static final long serialVersionUID = -7428665705397767944L;

	public PassengerNotFoundException(String passengerId) {
		super("Passenger", "passenger-id", passengerId);
	}
	
}
