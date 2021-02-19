package com.aitrich.services.flightBookingSystem.airport.request.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBookingSystem.airport.request.AirportCreateRequest;
import com.aitrich.services.flightBookingSystem.domain.entity.Airport;

@Component
public class ToAirportConverter implements Converter<AirportCreateRequest,Airport>{

	@Override
	public Airport convert(AirportCreateRequest source) {
		//return new Airport(source.getIataCode(),source.getName(),source.getCountryIsoCode());
		return new Airport(source.getIataCode(),source.getName(),source.getCountryIsoCode()
				);
	}

}
