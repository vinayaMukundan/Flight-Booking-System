package com.aitrich.services.flightBookingSystem.airport.response.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBookingSystem.airport.request.AirportCreateRequest;
import com.aitrich.services.flightBookingSystem.airport.response.AirportCreateResponse;
import com.aitrich.services.flightBookingSystem.domain.entity.Airport;

@Component
public class ToAirportCreateResponseConverter implements Converter<Airport,AirportCreateResponse>{
	
	@Override
	public AirportCreateResponse convert(Airport source) {
		return new AirportCreateResponse(source.getIataCode(), source.getName(), source.getCountryIsoCode());
	}

}
