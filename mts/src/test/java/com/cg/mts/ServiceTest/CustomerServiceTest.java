package com.cg.mts.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.Entity.Customer;
import com.cg.mts.repository.ICustomerRepository;
import com.cg.mts.service.ICustomerService;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	ICustomerService iCustomerService;
	
	@MockBean
	ICustomerRepository iCustomerRepository;
	
	
	@Test
	@DisplayName("Customer detalis should be added")
	public void insertCustomerservice() 
	{
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setEmail("subha@gmail.com");
		c.setMobileNumber("7980345542");
		c.setPassword("subha123");
		c.setUsername("subha007");
		when(iCustomerRepository.save(c)).thenReturn(c);
	}
	
	@Test
	@DisplayName("Customer details should be updated")
	public void updateCustomerservice() 
	{
		Optional<Customer> service = iCustomerRepository.findById(10);
		if(service.isPresent()) 
		{
			service.get().setUsername("subha007");
			iCustomerRepository.save(service.get());	
		}
		
		Optional<Customer> updatedCustomerservice = iCustomerRepository.findById(1);
		
		if(updatedCustomerservice.isPresent()) 
		{
			assertThat(updatedCustomerservice.get().getUsername().equals("subha007"));
		}
	}
	
	
	
	@Test
	@DisplayName("Should get customer by id")
	public void viewCustomerServiceById()
	{
		Optional<Customer> oc = iCustomerRepository.findById(1);
		if(oc.isPresent()) 
		{
			assertEquals(oc.get().getCustomerId(),1);
		}
	}
	
	
	
	@Test
	@DisplayName("Customer should be removed")
	public void removeCustomerservice() 
	{
		Customer c = new Customer();
		c.setCustomerId(1);
		Mockito.when(iCustomerRepository.findById(1)).thenReturn(Optional.of(c));
		Assertions.assertDoesNotThrow(() -> iCustomerService.deleteCustomer(c));
	}
	
	@Test
	@DisplayName("Should get a list of Customer")
	public void getAllCustomerservice()
	{
		List<Customer> list1= iCustomerRepository.findAll();
		List<Customer> list2= iCustomerRepository.viewCustomers();
		assertThat(list1.size()).isEqualTo(list2.size());
	}
	
	
	
	@Test
	@DisplayName("Customer should be validated by username and password")
	public void validateCustomerservice() 
	{
		Customer c = new Customer();
		
	  //  c.setCustomerId(1);
		c.setUsername("parth");
		c.setPassword("parth1234");
		c.setEmail("parth@gmail.com");
		c.setMobileNumber("9456767891");
		
		String u= c.getUsername();
		String p = c.getPassword();
		
		Mockito.when(iCustomerRepository.findByusername(Mockito.anyString())).thenReturn(Optional.of(c));
		Assertions.assertDoesNotThrow(() -> iCustomerService.validateCustomer(u,p));
	}
	
	
	
	/*@Test
	public void viewAllCustomerservice()
	{
		Customer c =new Customer();
		Customer c1 =new Customer();
		
		c.setUsername("parth");
		c.setPassword("parth1234");
		c.setEmail("parth@gmail.com");
		c.setMobileNumber("9456767891");
		
		c1.setUsername("mainak007");
		c1.setPassword("mainak123");
		c1.setEmail("mainak@gmail.com");
		c1.setMobileNumber("8765430981");
		
		List<Customer> customerList=new ArrayList<>();
		customerList.add(c);
		when(iCustomerRepository.findAll()).thenReturn(customerList);
		assertEquals(2,iCustomerService.viewCustomers().size());
		
	}*/
	
/*	@Test
	public void  getAllCustomerservice()
	{
		List<Customer> list1= iCustomerRepository.findAll();
		List<Customer> list2= iCustomerService.viewCustomers();
		assertThat(list1.size()).isEqualTo(list2.size());
	}*/
	
	
	
	/*@Test
	@DisplayName("Customer should be validated by username and password")
	public void validateCustomerservice() 
	{
		Customer c = new Customer();
		
	  //  c.setCustomerId(1);
		c.setUsername("parth");
		c.setPassword("parth1234");
		c.setEmail("parth@gmail.com");
		c.setMobileNumber("9456767891");
		
		String u= c.getUsername();
		String p = c.getPassword();
		
		Mockito.when(iCustomerRepository.findByusername(Mockito.anyString())).thenReturn(Optional.of(c));
		Assertions.assertDoesNotThrow(() -> iCustomerService.validateCustomer(u,p));
	}*/
	
	
	    
	
}