package com.aitrich.services.flightBookingSystem.booking.request.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBookingSystem.booking.request.BookingUpdateRequest;
import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.domain.entity.FlightBooking;
import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.flight.FlightService;
import com.aitrich.services.flightBookingSystem.flight.request.FlightCreateRequest;
import com.aitrich.services.flightBookingSystem.passenger.PassengerService;

@Component
public class ToBookingConverterFromUpdateReq implements Converter<BookingUpdateRequest, FlightBooking>{

	@Autowired
	PassengerService passengerService;
	
	@Autowired
	FlightService flightService;
	
	@Override
	public FlightBooking convert(BookingUpdateRequest source) {
		String id = source.getBookingId();
		
		List<FlightCreateRequest> flight = source.getFlights();
		Set<Flight> flightSet = new HashSet<>();
		
		for(FlightCreateRequest listf : flight) {
			List<Flight> flightObj = flightService.findFlightByAllField(listf.getDeparture(),
					listf.getDepartureDate(),listf.getArrival(),listf.getArrivalDate());
			flightSet.addAll(flightObj);
		}
		
		FlightBooking booking = new FlightBooking(null, null, flightSet);
		System.out.println(booking);
		
		return booking;
	}

}
