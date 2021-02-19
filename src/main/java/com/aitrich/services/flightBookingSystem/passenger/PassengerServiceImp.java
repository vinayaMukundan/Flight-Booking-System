package com.aitrich.services.flightBookingSystem.passenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.domain.repo.PassengerRepository;






@Service
@Transactional
public class PassengerServiceImp implements PassengerService{

	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	public PassengerServiceImp(PassengerRepository passengerRepo) {
		this.passengerRepo = passengerRepo;
	}
	
	@Override
	public Passenger insertPassenger(Passenger passenger) {
		return passengerRepo.save(passenger);
	}
	
	@Override
	public Passenger updatePassenger(Passenger passenger) {
		return passengerRepo.save(passenger);
	}
	
	@Override
	public Passenger getPassengerById(String passengerId) {
		return passengerRepo.findById(passengerId).orElseThrow(() -> new PassengerNotFoundException(passengerId));
	}
	
	@Override
	public List<Passenger> getAllPassengers() {
		return passengerRepo.findAll();
	}
	
	@Override
	public String deletePassenger(String id) {
		passengerRepo.deleteById(id);
		return "Passenger Deleted Successfully...!!";
	}
	@Override
	public Passenger findByEmail(String email) {
		return passengerRepo.findByEmail(email);
	}
}
