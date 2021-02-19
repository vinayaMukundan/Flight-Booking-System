package com.aitrich.services.flightBookingSystem.domain.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aitrich.services.flightBookingSystem.domain.entity.FlightBooking;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;


@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, String>{
	
	List<FlightBooking> findByPassengerId(String passengerId);
	
}

	
	
