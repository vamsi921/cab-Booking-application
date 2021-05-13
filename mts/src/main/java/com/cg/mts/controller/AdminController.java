package com.cg.mts.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.mts.Entity.Admin;
import com.cg.mts.Entity.TripBooking;
import com.cg.mts.Exception.AdminNotFoundException;
import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.service.IAdminService;


@RestController
public class AdminController {
	
	@Autowired
	IAdminService ias;
	
	//INSERT ADMIN
	@PostMapping("/insertAdmin")
	public Admin insertAdmin(@RequestBody Admin admin) {
		return ias.insertAdmin(admin);
	}

	//VIEW ALL ADMIN
	@GetMapping("/viewAllAdmin")
	public List<Admin> viewALlAdmin() {
		return ias.viewALlAdmin();
	}
	
	//DELETE ADMIN BY adminId
	@DeleteMapping("/deleteAdmin/{adminId}")
	public Admin deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException{	
		Admin a = null;
		try {
			a = ias.deleteAdmin(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with given ID: " + adminId + " Not Found to Delete");
		}
		return a;
	}
	
	//UPDATE ADMIN
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin)  throws AdminNotFoundException{
		Admin a = null;
		try {
			a = ias.getAdminById(admin.getAdminId());
			ias.updateAdmin(admin);
			return admin;
		} catch (Exception e) {
			throw new AdminNotFoundException("Admin Not Found to Update");
		}

//		ias.updateAdmin(admin);
			
	}

	@GetMapping("/admin/{adminId}")
	public Admin GetAdminById(@PathVariable int adminId) throws AdminNotFoundException {
		Admin a = null;
		try {
			a = ias.getAdminById(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with ID: " + adminId + " not found!");
		}
		return a;
	}
	
	//GETTING ALL TRIPS BY CUSTOMER_ID
	@GetMapping("/alltrips/{customerId}")
	public List<TripBooking> getAllTrips(@PathVariable int customerId) throws CustomerNotFoundException {
		List<TripBooking> t = null; 
		try {
			t = ias.getAllTrips(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Can not find trips of Customer ID: " + customerId);
		}
		return t;
	}
	
	//GETTING TRIPS CAB WISE
	@GetMapping("/tripsCabwise")
	public List<TripBooking> getTripsCabwise() {
		return ias.getTripsCabwise();
	}
	
	//GETTING TRIPS CUSTOMERWISE
	@GetMapping("/tripsCustomerwise")
	public List<TripBooking> getTripsCustomerwise() {
		return ias.getTripsCustomerwise();
	}
	
	//GETTING TRIPS DATE WISE
	@GetMapping("/tripsDatewise")
	public List<TripBooking> getTripsDatewise() {
		return ias.getTripsDatewise();
	}

	@GetMapping("fordays/{customerId}/{fromDate}/{toDate}")
	public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId,
			@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
			@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate)
			throws CustomerNotFoundException {
		return ias.getAllTripsForDays(customerId, fromDate, toDate);
	}
	

}
