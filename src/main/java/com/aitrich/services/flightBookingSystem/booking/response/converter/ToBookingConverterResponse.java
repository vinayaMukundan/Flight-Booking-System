package com.aitrich.services.flightBookingSystem.booking.response.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBookingSystem.booking.request.BookingCreateRequest;
import com.aitrich.services.flightBookingSystem.booking.response.BookingCreateResponse;
import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.domain.entity.FlightBooking;
import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.domain.repo.FlightRepository;
import com.aitrich.services.flightBookingSystem.flight.FlightService;
import com.aitrich.services.flightBookingSystem.flight.request.FlightCreateRequest;
import com.aitrich.services.flightBookingSystem.passenger.PassengerService;


@Component
public class ToBookingConverterResponse implements Converter<FlightBooking, BookingCreateResponse>{

	@Override
	public BookingCreateResponse convert(FlightBooking source) {
		
		return new BookingCreateResponse(source.getId(),
				source.getPassenger(), source.getFlights());
	}

	

}
