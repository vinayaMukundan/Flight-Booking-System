package com.aitrich.services.flightBookingSystem.passenger;

import java.util.List;

import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;





public interface PassengerService {

	Passenger getPassengerById(String passengerId);
	List<Passenger> getAllPassengers();
	
	Passenger insertPassenger(Passenger passenger);
	Passenger updatePassenger(Passenger passenger);
	String deletePassenger(String passengerId);
	
	Passenger findByEmail(String email);
	
}
