package com.cg.mts.ServiceImpl;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Entity.Customer;
import com.cg.mts.repository.ICustomerRepository;
import com.cg.mts.service.ICustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository iCustomerRepository;
	
    // ** Create new Customer **
	
	@Override
	public Customer insertCustomer(Customer customer)
	{
		return iCustomerRepository.save(customer);
	}
	
	// **Update the customer detalis**
	
	@Override
	public Customer updateCustomer( Customer customer) throws CustomerNotFoundException
	{
		Optional<Customer> orderdDetails = iCustomerRepository.findById(customer.getCustomerId());
		if (orderdDetails.isPresent())
			return iCustomerRepository.save(customer);
		else
			throw new CustomerNotFoundException(" Sorry customer doesnot exist");
		
	}
	//** Remove the Customer details **
	
	@Override
	public Customer deleteCustomer( Customer customer) throws CustomerNotFoundException
	{
		Optional<Customer> optional = iCustomerRepository.findById(customer.getCustomerId());
		if(optional.isPresent()) {
			iCustomerRepository.delete(customer);
			return customer;
		}
		else {
			throw new CustomerNotFoundException("Customer not found");
		}
		
	}
		
	//** Get List of Customers **	
	
	@Override
	public List<Customer> viewCustomers() throws CustomerNotFoundException 
	{
		List<Customer> customers = iCustomerRepository.findAll();
	   // customers.removeAll(customers);
		if(customers.isEmpty()) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		else 
		{
			return customers;
		}
	}
	
	//** Get the customer detalis by ID **
	
	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException
	{
		Optional<Customer> customer = iCustomerRepository.findById(customerId);
		
		if(!customer.isPresent()) 
		{
			throw new CustomerNotFoundException("Sorry Customer doesnot exist enter correct Id");
		}
		else
		{
			return customer.get();
		}
		
	}
	
	//**Validation of customer**
	
	@Override
	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException
	{
		Optional<Customer> oc =iCustomerRepository.findByusername(username);
		Customer cust = oc.orElseThrow(() -> new CustomerNotFoundException("Please enter valid username "));
		if(!username.equals(cust.getUsername())) {
			throw new CustomerNotFoundException("Please enter valid username .");
		}
			else if (!password.equals(cust.getPassword())) {
				throw new CustomerNotFoundException("password does not match");
			}
		
		return cust;
	}
		 
	
}
