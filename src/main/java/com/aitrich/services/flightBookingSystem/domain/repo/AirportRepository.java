package com.aitrich.services.flightBookingSystem.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aitrich.services.flightBookingSystem.domain.entity.Airport;



@Repository
public interface AirportRepository extends JpaRepository<Airport, String>{

}
