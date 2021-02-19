package com.aitrich.services.flightBookingSystem.booking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.domain.entity.FlightBooking;
import com.aitrich.services.flightBookingSystem.domain.repo.FlightBookingRepository;
import com.aitrich.services.flightBookingSystem.flight.FlightService;
import com.aitrich.services.flightBookingSystem.passenger.PassengerService;




@Service
@Transactional
public class BookingServiceImp implements BookingService{

	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImp.class);

	@Autowired
	FlightBookingRepository bookingRepo;
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	FlightService flightService;

	@PersistenceContext
    private EntityManager manager;
	
	@Autowired
	public BookingServiceImp(FlightBookingRepository bookingRepo) {
		this.bookingRepo = bookingRepo;
	}
	
	
	@Override
	public FlightBooking insertBooking(FlightBooking model) {
		System.out.println("inside serv imp");
		
		System.out.println(model.getPassenger()+"<<<>>>>"+model.getFlights());
		
		return bookingRepo.save(model);
	}
	@Override
	public FlightBooking updateBooking(FlightBooking model){
		//getBooking(model.getId());
		FlightBooking flightBooking = bookingRepo.save(model);
		return flightBooking;
	}
	@Override
	public String deleteBookingbyFlightid(String bookingId) {
		bookingRepo.deleteById(bookingId);
		return "Deleted..";
	}
	@Override
	public FlightBooking getBooking(String bookingId) {
		return bookingRepo.findById(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));
	}
	

	@Override
	public List<FlightBooking> getAllBookingsByPassenger(String passengerId) {
		
		List<FlightBooking> bookings = bookingRepo.findByPassengerId(passengerId);
		
		if (CollectionUtils.isEmpty(bookings))
			throw new BookingNotFoundForPassengerException(passengerId);
		return bookings;
	}
	
	@Override
	public List<FlightBooking> getAllMultiFlightBookingsByPassenger(String passengerId) {
		List<FlightBooking> bookings = bookingRepo.findByPassengerId(passengerId);
		logger.debug(">>>>>>>>>>>>>>>>>>>>>"+bookings);
		return bookings.stream().filter(booking -> booking.getFlights().size() > 1).collect(Collectors.toList());
	}
	
	@Override
	public List<FlightBooking> getAllMultiFlightBookings() {
		List<FlightBooking> bookings = bookingRepo.findAll();
		logger.debug(">>>>>>>>>>>>>>>>>>>>>"+bookings);
		return bookings;
	}
	
}
