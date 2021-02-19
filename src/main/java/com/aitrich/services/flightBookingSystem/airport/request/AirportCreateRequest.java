package com.aitrich.services.flightBookingSystem.airport.request;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AirportCreateRequest {
	
	@Id
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	@NotEmpty
	private String iataCode;

	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "countryIsoCode is mandatory")
	@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String countryIsoCode;

	public AirportCreateRequest() {
		super();
	}

	public AirportCreateRequest( String iataCode,
			String name,
			String countryIsoCode) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.countryIsoCode = countryIsoCode;
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

	@Override
	public String toString() {
		return "AirportCreateRequest [iataCode=" + iataCode + ", name=" + name + ", countryIsoCode=" + countryIsoCode
				+ "]";
	}
	
	
}
