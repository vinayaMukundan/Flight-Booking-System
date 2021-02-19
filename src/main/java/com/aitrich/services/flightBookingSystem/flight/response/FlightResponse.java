package com.aitrich.services.flightBookingSystem.flight.response;

import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FlightResponse {
	
	@Id
	private String id;
	
	@NotBlank(message = "departure is mandatory")
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String departure;
	
	@NotBlank(message = "arrival is mandatory")
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String arrival;
	
	@NotNull
	private LocalDateTime departureDate;
	
	@NotNull
	private LocalDateTime arrivalDate;

	public FlightResponse(String id,
			@NotBlank(message = "departure is mandatory") @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input") String departure,
			@NotBlank(message = "arrival is mandatory") @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input") String arrival,
			@NotNull LocalDateTime departureDate, @NotNull LocalDateTime arrivalDate) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	public FlightResponse() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "FlightResponse [id=" + id + ", departure=" + departure + ", arrival=" + arrival + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + "]";
	}
	
	

}
