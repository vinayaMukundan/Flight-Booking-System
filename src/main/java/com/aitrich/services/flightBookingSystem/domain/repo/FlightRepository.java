package com.aitrich.services.flightBookingSystem.domain.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aitrich.services.flightBookingSystem.domain.entity.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, String>{

	@Query(value = "select f from Flight f where f.departure =?1 and f.departureDate >= ?2")
	List<Flight> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate);
	
	@Query(value="Select * From Flight f where f.arrival=?1 and f.arrival_date >=?2 and f.departure =?3 and f.departure_date >=?4",nativeQuery= true)
	List<Flight> findFlightByAllField(String arrival, LocalDateTime arrivalDate,String departure,LocalDateTime departureDate);
}
