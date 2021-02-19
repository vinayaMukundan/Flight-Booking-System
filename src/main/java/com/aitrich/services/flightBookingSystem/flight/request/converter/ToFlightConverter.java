package com.aitrich.services.flightBookingSystem.flight.request.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.flight.request.FlightCreateRequest;


@Component
public class ToFlightConverter implements Converter<FlightCreateRequest, Flight>{

	@Override
	public Flight convert(FlightCreateRequest source) {
		return new Flight(null, source.getDeparture(), 
				source.getArrival(), source.getDepartureDate(), source.getArrivalDate(), null);
	}

}
