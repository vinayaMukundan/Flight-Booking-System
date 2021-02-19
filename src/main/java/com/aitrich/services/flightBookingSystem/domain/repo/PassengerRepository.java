package com.aitrich.services.flightBookingSystem.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String>{

	@Query(value ="select p from Passenger p where p.email = ?1",nativeQuery=true)
	Passenger findByEmail(String email);
	
}
