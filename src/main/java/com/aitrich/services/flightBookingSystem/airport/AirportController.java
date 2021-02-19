package com.aitrich.services.flightBookingSystem.airport;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aitrich.services.flightBookingSystem.airport.request.AirportCreateRequest;
import com.aitrich.services.flightBookingSystem.airport.request.converter.ToAirportConverter;
import com.aitrich.services.flightBookingSystem.airport.response.AirportCreateResponse;
import com.aitrich.services.flightBookingSystem.airport.response.converter.ToAirportCreateResponseConverter;
import com.aitrich.services.flightBookingSystem.domain.entity.Airport;
import com.aitrich.services.flightBookingSystem.exception.ResourceNotFoundException;



@RestController
@RequestMapping("/airport")
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	@Autowired
	private ToAirportConverter toAirportConverter;
	
	@Autowired
	private ToAirportCreateResponseConverter toAirportCreateResponseConverter;
	
	@PostMapping
	public ResponseEntity<AirportCreateResponse> saveAirport(@RequestBody @Valid AirportCreateRequest airportCreateReuest)  
	{  
		Airport airportObj = airportService.insertAirport(toAirportConverter.convert(airportCreateReuest));
		AirportCreateResponse responseObj = toAirportCreateResponseConverter.convert(airportObj);
		if(responseObj== null) {
			throw new ResourceNotFoundException("Resource Not Found", "Insertion Failed", null);
		}
		return new ResponseEntity<AirportCreateResponse>(responseObj,HttpStatus.OK);
	}
	
	@PutMapping("/{iata-code}")
	private ResponseEntity<Airport> updateAirport(@PathVariable(value = "iata-code") String iataCode ,@RequestBody @Valid Airport airport)   
	{  
		airportService.getAirportById(iataCode);
		Airport airportUpdated = airportService.updateAirport(airport);
		if(airportUpdated==null) {
			return new ResponseEntity<Airport>(airportUpdated,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Airport>(airportUpdated,HttpStatus.OK);
	}  
	
	@GetMapping("/{iata-code}")
	public ResponseEntity<Airport> getAirportById(@PathVariable("iata-code") @NotBlank String iataCode){
	  Airport airport = airportService.getAirportById(iataCode);
	  return new ResponseEntity<Airport>(airport, HttpStatus.OK);
	}
	
	@GetMapping
	public @ResponseBody List<Airport> getAllAirports() {
		return airportService.getAllAirports();
	}
	
	@DeleteMapping("/{iata-code}")  
	private ResponseEntity<String> deleteAirport(@PathVariable("iata-code") @NotBlank String iataCode)   
	{  
		airportService.getAirportById(iataCode);
		String message = airportService.deleteAirport(iataCode);
		return ResponseEntity.ok(message);
	}  
	
	
	/*@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	*/
	
//	@RequestMapping("/login")
//	public String saveAirport()   
//	{  
//		System.out.println("====================");
//		return "HELLO WORLD...";
//	}
//	
	
	/*@RequestMapping(value = "authenticate",method= RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest autheticationRequest) throws Exception   
	{  
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(autheticationRequest.getUsername(),
				autheticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect user name or password " , e);
		}
		
		final UserDetails userDetails =userDetailsService.loadUserByUsername(autheticationRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}*/
}
