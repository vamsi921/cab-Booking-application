package com.cg.mts.service;

import java.util.List;



import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.Entity.Customer;



public interface ICustomerService {
	
	public Customer insertCustomer(Customer customer) ;
	public Customer updateCustomer(Customer customer)throws CustomerNotFoundException;
	public Customer deleteCustomer(Customer customer)throws CustomerNotFoundException;
	public List<Customer> viewCustomers() throws CustomerNotFoundException;
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
}