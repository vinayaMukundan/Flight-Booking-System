package com.aitrich.services.flightBookingSystem.booking.request.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBookingSystem.booking.request.BookingCreateRequest;
import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.domain.entity.FlightBooking;
import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.domain.repo.FlightRepository;
import com.aitrich.services.flightBookingSystem.flight.FlightService;
import com.aitrich.services.flightBookingSystem.flight.request.FlightCreateRequest;
import com.aitrich.services.flightBookingSystem.passenger.PassengerService;


@Component
public class ToBookingConverter implements Converter<BookingCreateRequest, FlightBooking>{

	@Autowired
	FlightService flightService;
	
	@Autowired
	PassengerService passengerService;
	 
	@Override
	public FlightBooking convert(BookingCreateRequest source) {
		System.out.println(">>>>>>>>inside converter>>>>"+source);
		Passenger passenger = passengerService.getPassengerById(source.getPassengerId());
		
		String arrival = source.getArrival();
		String arrivalDate = source.getArrivalDate();
		String departure = source.getDeparture();
		String departureDate = source.getDepartureDate();
		
		DateTimeFormatter GlobalDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime.parse(departureDate, GlobalDateFormatter);
		LocalDateTime.parse(arrivalDate, GlobalDateFormatter);
		
		Set<Flight> flightSet = new HashSet<Flight>();
		
		List<Flight> flightList = flightService.findFlightByAllField(arrival, LocalDateTime.parse(arrivalDate, GlobalDateFormatter),
										departure, LocalDateTime.parse(arrivalDate, GlobalDateFormatter));
		//for(Flight flightObj : flightList) {
			flightSet.addAll(flightList);
		//}
		
			System.out.println(">>>>>>>>inside LIST  converter>>>>"+flightList);
			System.out.println(">>>>>>>>inside SET rter>>>>"+flightSet);

			
			
		FlightBooking b = new FlightBooking(null, passenger,flightSet );
		System.out.println(">>>>>>>>inside>>>>"+b);
		return b;
	}
}
