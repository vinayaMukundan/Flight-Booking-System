package com.aitrich.services.flightBookingSystem.passenger;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.services.flightBookingSystem.airport.response.AirportCreateResponse;
import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.exception.ResourceNotFoundException;
import com.aitrich.services.flightBookingSystem.passenger.request.PassengerCreateRequest;
import com.aitrich.services.flightBookingSystem.passenger.request.converter.ToPassengerConverter;
import com.aitrich.services.flightBookingSystem.passenger.response.converter.ToPassengerRequestConverter;



@RestController
@RequestMapping("/passengers")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private ToPassengerConverter toPasseengerConverter;
	
	@Autowired
	private ToPassengerRequestConverter toPassengerRequestConverter;

	@PostMapping 
	private  ResponseEntity<Passenger> savePassengerDetails(@Valid @RequestBody PassengerCreateRequest passengerModel)   
	{  
		Passenger passenger = toPasseengerConverter.convert(passengerModel);
		Passenger passengerSaved = passengerService.insertPassenger(passenger);
		if(passengerSaved== null) {
			throw new ResourceNotFoundException("Resource Not Found", "Insertion Failed", null);
		}
		return new ResponseEntity<Passenger>(passengerSaved,HttpStatus.OK);
	}
	
	
	
	@PutMapping 
	private ResponseEntity<Passenger> updatePassengerDetails(@Valid @RequestBody PassengerCreateRequest passengerModel)   
	{  
		Passenger passenger = toPasseengerConverter.convert(passengerModel);
		Passenger passengerSaved = passengerService.updatePassenger(passenger);
		return new ResponseEntity<Passenger>(passengerSaved,HttpStatus.OK);
	} 
	
	@GetMapping("{passenger-id}")
	public @ResponseBody Passenger getPassengerById(@Valid @RequestParam("passenger-id") String passengerId) {
		return passengerService.getPassengerById(passengerId);
		
	}
	
	@GetMapping("/getAllPassengers")
	public @ResponseBody List<PassengerCreateRequest> getAllPassengers() {
		List<Passenger> passengerList = passengerService.getAllPassengers();
		List<PassengerCreateRequest> passengerModelList = new ArrayList<PassengerCreateRequest>();
		for(Passenger passengerObj :passengerList ) {
			PassengerCreateRequest passengerModelObj = toPassengerRequestConverter.convert(passengerObj);
			passengerModelList.add(passengerModelObj);
		}
		return passengerModelList;
	}
	
	@GetMapping("{email}")
	public ResponseEntity<Passenger> getPassengerByEmail(@PathVariable("email") @NotNull String email) {
		Passenger passenger = passengerService.findByEmail(email);
		System.out.println(passenger);
		return new ResponseEntity<Passenger>(passenger,HttpStatus.OK);
	}
	
	@DeleteMapping("{passenger-id}")  
	private ResponseEntity<String> deletePassengerDetails(@PathVariable("passenger-id") String passengerId)   
	{  
		String message = passengerService.deletePassenger(passengerId);
		return ResponseEntity.ok(message);
	}  
	
	
	
}
