package com.aitrich.services.flightBookingSystem.booking;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.services.flightBookingSystem.airport.response.AirportCreateResponse;
import com.aitrich.services.flightBookingSystem.booking.request.BookingCreateRequest;
import com.aitrich.services.flightBookingSystem.booking.request.BookingUpdateRequest;
import com.aitrich.services.flightBookingSystem.booking.request.converter.ToBookingConverter;
import com.aitrich.services.flightBookingSystem.booking.request.converter.ToBookingConverterFromUpdateReq;
import com.aitrich.services.flightBookingSystem.booking.response.BookingCreateResponse;
import com.aitrich.services.flightBookingSystem.booking.response.converter.ToBookingConverterResponse;
import com.aitrich.services.flightBookingSystem.domain.entity.Airport;
import com.aitrich.services.flightBookingSystem.domain.entity.Flight;
import com.aitrich.services.flightBookingSystem.domain.entity.FlightBooking;
import com.aitrich.services.flightBookingSystem.domain.entity.Passenger;
import com.aitrich.services.flightBookingSystem.exception.ResourceNotFoundException;
import com.aitrich.services.flightBookingSystem.flight.FlightService;
import com.aitrich.services.flightBookingSystem.flight.request.FlightCreateRequest;
import com.aitrich.services.flightBookingSystem.passenger.PassengerService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;





@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private BookingService bookingService;

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private ToBookingConverter toBookingConverter;
	@Autowired
	private ToBookingConverterFromUpdateReq toBookingConverterFromUpdateReq;
	
	@Autowired
	private ToBookingConverterResponse toBookingConverterResponse;
	
	
	
	@DeleteMapping("{bookingId}")
	public ResponseEntity<String> deleteBookingById(@PathVariable("bookingId") String model) {

		logger.info("Finding booking by id ... " + model);
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<"+model);
		//toBookingModelConverter.convert(bookingService.deleteBooking(bookingId));
		String message = bookingService.deleteBookingbyFlightid(model);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	
	@PostMapping 
	private ResponseEntity<BookingCreateResponse> saveBooking(@RequestBody BookingCreateRequest bookingCreateRequest)   
	{  
		FlightBooking booingSaved; 
		FlightBooking flightBooking = toBookingConverter.convert(bookingCreateRequest);
		if(!flightBooking.getFlights().isEmpty()) {
			booingSaved = bookingService.insertBooking(flightBooking);
		}
		else
			throw new ResourceNotFoundException("Resource Not Found", "Insertion Failed", null);
		return new ResponseEntity<BookingCreateResponse>(toBookingConverterResponse.convert(booingSaved),HttpStatus.OK);		
	} 
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<FlightBooking> getBookingById(@PathVariable @NotEmpty String bookingId) {
		logger.info("Finding booking by id ... " + bookingId);
		return new ResponseEntity<FlightBooking>(bookingService.getBooking(bookingId),HttpStatus.OK);
	}
	
	@PutMapping("/{bookingId}")
	private ResponseEntity<FlightBooking> updateBooking(@PathVariable(value = "bookingId") String bookingId ,@Valid @RequestBody BookingUpdateRequest bookingUpdateRequest)   
	{  
		bookingService.getBooking(bookingId);
		FlightBooking booking =  toBookingConverterFromUpdateReq.convert(bookingUpdateRequest);
		FlightBooking flightBookingUpdated = bookingService.updateBooking(booking);
		if(flightBookingUpdated==null) {
			return new ResponseEntity<FlightBooking>(flightBookingUpdated,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<FlightBooking>(flightBookingUpdated,HttpStatus.OK);
	} 
	
	
//	@GetMapping
//	public @ResponseBody List<FlightBookingModel> getAllBookingDetails() {
//		logger.info("Finding booking by id ... " );
//		//bookingService.getAllMultiFlightBookings();
//		
//		List<FlightBooking> flightBookings = bookingService.getAllMultiFlightBookings();
//
//		List<FlightBookingModel> flightBookingModel = new ArrayList<FlightBookingModel>();
//		for(FlightBooking flightBooking :flightBookings ) {
//			FlightBookingModel flightModel = toBookingModelConverter.convert(flightBooking);
//			flightBookingModel.add(flightModel);
//		}
//		return flightBookingModel;
//	}
	
	
	
	
	

//	@GetMapping("getAllBookingByPassengerId")
//	public @ResponseBody List<FlightBookingSummaryModel> getBookings(
//			@RequestParam(required = false, name = "uid") String passengerId, 
//			@RequestParam(required = false, name = "multi-flights", defaultValue = "false") boolean multiFlights) {
//
//		logger.info("Finding booking by passengerId ... " + passengerId);
//		logger.info("Finding booking by passengerId ... " + multiFlights);
//
//		List<FlightBooking> bookings = null;
//		
//		if(!StringUtils.isEmpty(passengerId)) {
//				System.out.println("000000000000000------------get all  Booking by passenger  ");
//				bookings = bookingService.getAllBookingsByPassenger(passengerId);
//		} else {
//			throw new BookingNotFoundException(null);
//		}
//		
//		List<FlightBookingSummaryModel> bookingModels = new ArrayList<>(bookings.size());
//		bookings.stream().forEach(booking -> {
//			bookingModels.add(new FlightBookingSummaryModel(booking.getId(), booking.getPassenger().getLastName(),
//					((Flight) booking.getFlights().toArray()[0]).getDeparture()));
//		});
//		return bookingModels;
//	}

}
