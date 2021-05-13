package com.cg.mts.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.Entity.Driver;
import com.cg.mts.service.IDriverService;

@RestController
@RequestMapping("mts/api")
public class DriverController {
	
	@Autowired
    IDriverService idriverService;
	
	@PostMapping
	@RequestMapping("/insertdriver")
	public Driver insertDriver(@RequestBody Driver driver) {
		return idriverService.insertDriver(driver);
	
	}
	
	@PutMapping
	@RequestMapping("/updatedriver")
	public Driver updateDriver(@RequestBody Driver driver)
	{
		return idriverService.updateDriver(driver);
	}
	
	@GetMapping("/driver/{driverId}")
	public Driver viewDriver(@PathVariable Integer driverId)
	{
		return idriverService.viewDriver(driverId);
		
	}

	@DeleteMapping
	@RequestMapping("/deletedriver")
	public Driver deleteDriver(@PathVariable Integer driverId) 
	{
		return idriverService.deleteDriver(driverId);
	}

	
	@GetMapping 
	@RequestMapping("/bestDriver")
	public List<Driver> viewBestDrivers()  {
		return idriverService.viewBestDrivers(); 
		
	}

}
