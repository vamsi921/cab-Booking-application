package com.cg.mts.controller;
import java.util.List;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.mts.Entity.Cab;

import com.cg.mts.Exception.CabNotFoundException;
import com.cg.mts.ServiceImpl.CabServiceImpl;
import com.cg.mts.service.ICabService;

//import antlr.collections.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api/cab")
public class CabController {
	
	@Autowired
	ICabService iCabService;
	
	@PostMapping
	@RequestMapping("/insertcab")
		public Cab insertCab(@Valid @RequestBody Cab cab) 
	{
			return iCabService.insertCab(cab);
	}
	
	
	@PutMapping
	@RequestMapping("/updatecab")
	public Cab updateCab(@Valid @RequestBody Cab cab) throws CabNotFoundException
	{
		return iCabService.updateCab(cab);
	}
	
	
	
	@DeleteMapping
	@RequestMapping("/deletecabr")
	public Cab deleteCustomer(@Valid @RequestBody Cab cab) throws CabNotFoundException
	{
		return iCabService.deleteCab(cab);
	}
	
	
	

	@GetMapping("/getCartype/{cartype}")
	public List<Cab> viewCabsOfType (@PathVariable String cartype) throws CabNotFoundException
	{
		return iCabService.viewCabsOfType(cartype);
		
	}
	
	
	@GetMapping
	@RequestMapping("/getCarCount/{cartype}")
	public int countCabsOfType(@PathVariable String cartype) throws CabNotFoundException
	{
		return iCabService.countCabsOfType(cartype);
	}
	
}
