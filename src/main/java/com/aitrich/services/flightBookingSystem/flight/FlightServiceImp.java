package com.aitrich.services.flightBookingSystem.flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.domain.repo.FlightRepository;



@Service
@Transactional
public class FlightServiceImp implements FlightService{

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	public FlightServiceImp(FlightRepository flightRepo) {
		this.flightRepo = flightRepo;
	}
	
	@Override
	public Flight insertFlight(Flight flight) {
		return flightRepo.save(flight);
	}
	
	@Override
	public Flight updateFlight(Flight flight) {
		return flightRepo.save(flight);
	}
	
	@Override
	public List<Flight> getAllFlights() {
		return flightRepo.findAll();
	}
	@Override
	public Flight getFlightById(String flightId) {
		return flightRepo.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));
	}
	@Override
	public String deleteFlight(String flightId) {
		flightRepo.deleteById(flightId);
		return "Flight Deleted Successfully...!!";
	}
	
	@Override
	public List<Flight> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate) {
		return flightRepo.findByDepartureAndDepartureDateGreaterThan(departure, departureDate);
	}

	@Override
	public List<Flight> findFlightByAllField(String arrival, LocalDateTime arrivalDate, String departure,
			LocalDateTime departureDate) {
		return flightRepo.findFlightByAllField(arrival, arrivalDate, departure, departureDate);
	}
}
