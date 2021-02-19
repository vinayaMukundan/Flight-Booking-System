package com.aitrich.services.flightBookingSystem.airport.request;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AirportUpdateRequest {
	
	@Id
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String iataCode;

	
	@NotBlank(message = "Name is mandatory")
	@Size(min = 2 ,message = "name should have atleast 2 characters")
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String name;
	
	@NotBlank(message = "countryIsoCode is mandatory")
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String countryIsoCode;

	public AirportUpdateRequest(@Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input") String iataCode,
			@NotBlank(message = "Name is mandatory") @NotNull @Size(min = 2, message = "name should have atleast 2 characters") @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input") String name,
			@NotNull @NotBlank(message = "countryIsoCode is mandatory") @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Input") String countryIsoCode) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.countryIsoCode = countryIsoCode;
	}

	public AirportUpdateRequest() {
		super();
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}
}
