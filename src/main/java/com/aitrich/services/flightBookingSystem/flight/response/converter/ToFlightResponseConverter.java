package com.aitrich.services.flightBookingSystem.flight.response.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.flight.response.FlightResponse;


@Component
public class ToFlightResponseConverter implements Converter<Flight, FlightResponse>{

	@Override
	public FlightResponse convert(Flight source) {
		// TODO Auto-generated method stub
		return new FlightResponse(source.getId(),
				source.getDeparture(),
				source.getArrival(),
				source.getDepartureDate(), 
				source.getArrivalDate());
	}

}
