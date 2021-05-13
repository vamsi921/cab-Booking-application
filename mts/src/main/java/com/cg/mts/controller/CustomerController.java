package com.cg.mts.controller;

import java.util.List;

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

import com.cg.mts.Entity.Customer;
import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService iCustomerService;
	
	@PostMapping
	@RequestMapping("/insertcustomer")
		public Customer insertCustomer(@RequestBody Customer customer) {
			return iCustomerService.insertCustomer(customer);
	}
	
	
	@PutMapping
	@RequestMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException
	{
		return iCustomerService.updateCustomer(customer);
	}
	
	
	
	@DeleteMapping
	@RequestMapping("/deletecustomer")
	public Customer deleteCustomer(@Valid @RequestBody Customer customer) throws CustomerNotFoundException
	{
		return iCustomerService.deleteCustomer(customer);
	}
	
	
	
	
	@GetMapping
	@RequestMapping("/getCustomers")
	public List<Customer> viewCustomers() throws CustomerNotFoundException
	{
		return iCustomerService.viewCustomers();
	}
	
	
	
	@GetMapping("/getCustomerById/{customerId}")
	public Customer  viewCustomer(@PathVariable Integer customerId) throws CustomerNotFoundException
	{
		return iCustomerService.viewCustomer(customerId);
		
	}
	
	
	@GetMapping
	@RequestMapping("/validate/{username}/{password}")
	public Customer validateCustomer(@PathVariable String username, @PathVariable String password) throws  CustomerNotFoundException
	{
		return iCustomerService.validateCustomer(username, password);
	}
	
}
