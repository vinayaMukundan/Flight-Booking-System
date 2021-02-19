package com.aitrich.services.flightBookingSystem.passenger.response.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.passenger.request.PassengerCreateRequest;

@Component
public class ToPassengerRequestConverter implements Converter<Passenger, PassengerCreateRequest>{

	@Override
	public PassengerCreateRequest convert(Passenger source) {
		// TODO Auto-generated method stub
		return new PassengerCreateRequest(source.getFirstName(), source.getLastName(), source.getEmail());
	}

}
