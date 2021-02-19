package com.aitrich.services.flightBookingSystem.flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
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
import com.aitrich.services.flightBookingSystem.domain.entity.Airport;
import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.exception.ResourceNotFoundException;
import com.aitrich.services.flightBookingSystem.flight.request.FlightCreateRequest;
import com.aitrich.services.flightBookingSystem.flight.request.converter.ToFlightConverter;
import com.aitrich.services.flightBookingSystem.flight.response.FlightResponse;
import com.aitrich.services.flightBookingSystem.flight.response.converter.ToFlightResponseConverter;
import com.sun.istack.NotNull;


@RestController
@RequestMapping("flights")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
//	@Autowired
//	private ToFlightModelConverter toFlightModelConverter;
	
	@Autowired
	private ToFlightConverter toFlightConverter;
	
	@Autowired
	private ToFlightResponseConverter toFlightResponseConverter;
	
	/*@Autowired
	private BookingService bookingService;*/
	
	
	@PostMapping 
	private ResponseEntity<Flight> saveFlight(@Valid @RequestBody FlightCreateRequest flightCreateRequest)   
	{  
		Flight flight = flightService.insertFlight(toFlightConverter.convert(flightCreateRequest)); 
		if(flight== null) {
			throw new ResourceNotFoundException("Resource Not Found", "Insertion Failed", null);
		}
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}	

	@PutMapping  
	private ResponseEntity<Flight> updateFlight(@Valid @RequestBody Flight flight)   
	{  
		flightService.getFlightById(flight.getId());
		Flight flightUpdated = flightService.updateFlight(flight);
		return new ResponseEntity<Flight>(flightUpdated,HttpStatus.OK);
	}
	
	
	@GetMapping
	public @ResponseBody List<FlightResponse> getAllFlights() {
		List<Flight> flightList = flightService.getAllFlights();
		List<FlightResponse> flightResponseList = new ArrayList<FlightResponse>();
		for(Flight flighObj :flightList ) {
			FlightResponse flightRes = toFlightResponseConverter.convert(flighObj);
			flightResponseList.add(flightRes);
		}
		return flightResponseList;
	}
	
	@GetMapping("{flight-id}")
	public @ResponseBody FlightResponse getFlightById(@PathVariable("flight-id") @NotNull String flightId) {
		return toFlightResponseConverter.convert(flightService.getFlightById(flightId));
	}
	
	@DeleteMapping("{flight-id}")  
	private ResponseEntity<String> deleteFlight(@PathVariable("flight-id") @NotNull String flightId)   
	{  
		String message =flightService.deleteFlight(flightId);
		return ResponseEntity.ok(message);
	} 

	@GetMapping("{departure}/{departureDate}")
	public @ResponseBody List<Flight> findByDateAndPlace(@PathVariable("departure")@NotNull String departure, @PathVariable("departureDate") @NotNull String departureDate)
	{
		DateTimeFormatter GlobalDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime.parse(departureDate, GlobalDateFormatter);
		return flightService.findByDepartureAndDepartureDateGreaterThan(departure, LocalDateTime.parse(departureDate, GlobalDateFormatter));
	}
	
	@GetMapping("{arrival}/{arrivalDate}/{departure}/{departureDate}")
	public @ResponseBody List<Flight> findByArrival(@PathVariable("arrival")@NotNull String arrival,
						@PathVariable("arrivalDate") @NotNull String arrivalDate,
						@PathVariable("departure")@NotNull String departure,
						@PathVariable("departureDate") @NotNull String departureDate)
	{
		DateTimeFormatter GlobalDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime.parse(departureDate, GlobalDateFormatter);
		LocalDateTime.parse(arrivalDate, GlobalDateFormatter);
		return flightService.findFlightByAllField(arrival,LocalDateTime.parse(arrivalDate, GlobalDateFormatter),departure, LocalDateTime.parse(departureDate, GlobalDateFormatter));
	}
	
}
