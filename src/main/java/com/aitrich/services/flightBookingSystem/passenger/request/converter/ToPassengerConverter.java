package com.aitrich.services.flightBookingSystem.passenger.request.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.passenger.request.PassengerCreateRequest;

@Component
public class ToPassengerConverter implements Converter<PassengerCreateRequest,Passenger>{

	@Override
	public Passenger convert(PassengerCreateRequest source) {
		// TODO Auto-generated method stub
		return new Passenger(null, source.getFirstName(),
				source.getLastName(), source.getEmail(), null);
	}

}
