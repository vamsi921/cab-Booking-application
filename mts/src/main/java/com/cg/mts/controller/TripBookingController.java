package com.cg.mts.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Entity.TripBooking;
import com.cg.mts.service.ITripBookingService;

@RestController
@RequestMapping(path="/rest/trip")
public class TripBookingController {

	@Autowired
	ITripBookingService tripservice;
	
	@PostMapping("/insertTrip")
	public ResponseEntity<TripBooking> insertTripBooking(@RequestBody TripBooking tripbooking){
		tripservice.insertTripBooking(tripbooking);
		return ResponseEntity.ok(tripbooking);
	}
	
	@PutMapping("/updatetripbooking")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripbooking){
		tripservice.updateTripBooking(tripbooking);
		return ResponseEntity.ok(tripbooking);
	
	}
	@DeleteMapping("/deletetrip")
	public ResponseEntity<TripBooking> deleteTripBooking(@RequestBody TripBooking tripbooking)
	{
		tripservice.deleteTripBooking(tripbooking);
		return ResponseEntity.ok(tripbooking);
	}
	@GetMapping("/{customerId}")
	public List<TripBooking>  ViewAllTripsCustomer(@PathVariable("customerId") int customerId){
		 return tripservice.ViewAllTripsCustomer(customerId);
	}
	
	/*@GetMapping("/bill/{customerId}")
 	public ResponseEntity<Object>calculateBill(@PathVariable("customerId") int customerId) {
 		Double bookingData;
 		try {
 			bookingData = tripservice.calculateBill(customerId);
 			return new ResponseEntity<Object>(bookingData, HttpStatus.OK);
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();

 		}
 		return new ResponseEntity<Object>("No Bookings found in DataBase with given ID", HttpStatus.UNAUTHORIZED);

 	}*/
   
}
