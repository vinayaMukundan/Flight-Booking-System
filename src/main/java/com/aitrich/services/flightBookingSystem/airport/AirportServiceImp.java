package com.aitrich.services.flightBookingSystem.airport;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aitrich.services.flightBookingSystem.domain.entity.Airport;
import com.aitrich.services.flightBookingSystem.domain.repo.AirportRepository;


@Service
@Transactional
public class AirportServiceImp implements AirportService{
	
	@Autowired
	AirportRepository airportRepo;
	
	@Autowired
	public AirportServiceImp(AirportRepository airportRepo) {
		this.airportRepo = airportRepo;
	}
	
	@Override
	public Airport insertAirport(Airport airport){
		return airportRepo.save(airport);	
	}
	
	@Override
	public Airport updateAirport(Airport airport) {
		return airportRepo.save(airport);
	}
	
	@Override
	public Airport getAirportById(String iataCode) {
		return airportRepo.findById(iataCode).orElseThrow(() -> new AirportNotFoundException(iataCode));
	}
	
	@Override
	public List<Airport> getAllAirports() {
		return airportRepo.findAll();
	}
	
	@Override
	public String deleteAirport(String iataCode) {
		airportRepo.deleteById(iataCode);
		return "Airport Deleted Successfully...!!";
	}
}
