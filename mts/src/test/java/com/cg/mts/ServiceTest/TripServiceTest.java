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
import com.cg.mts.Entity.TripBooking;
import com.cg.mts.repository.ICustomerRepository;

@SpringBootTest
public class TripServiceTest {

	@Autowired
	com.cg.mts.service.ITripBookingService iTripBookingService;
	
	@MockBean
	com.cg.mts.repository.ITripBookingRepository iTripBookingRepository;
	
	
	@Test
	@DisplayName("Trip detalis should be added")
	public void insertCustomerservice() 
	{
		TripBooking c = new TripBooking();
		c.setTripBookingId(1);
		c.setCustomerId(15);
	//	c.setDriver(23);
	
	    
	    c.setFromLocation("nellore");
	    c.setToLocation("chennai");
	   // c.setFromDateTime("01-23-2020");
	   // c.setToDateTime("02-23-2020");
	    //c.setStatus("pending");
	    c.setDistanceInKm(25);
	    c.setBill(500);
		
		when(iTripBookingRepository.save(c)).thenReturn(c);
	}
	
	@Test
	@DisplayName("TripBooking details should be updated")
	public void updateCustomerservice() 
	{
		Optional<TripBooking> service = iTripBookingRepository.findById(10);
		if(service.isPresent()) 
		{
			service.get().setTripBookingId(12);
			iTripBookingRepository.save(service.get());	
		}
		
		Optional<TripBooking> updatedTripBookingservice = iTripBookingRepository.findById(1);
		
		if(updatedTripBookingservice.isPresent()) 
		{
		//	assertThat(updatedTripBookingservice.get().getTripBookingId().equals('12'));
		}
	}
	
	
	
	/*@Test
	@DisplayName("Should get customer by id")
	public void viewCustomerServiceById()
	{
		Optional<Customer> oc = iCustomerRepository.findById(1);
		if(oc.isPresent()) 
		{
			assertEquals(oc.get().getCustomerId(),1);
		}
	}*/
	
	
	
	@Test
	@DisplayName("TripBooking should be removed")
	public void removeCustomerservice() 
	{
		TripBooking c = new TripBooking();
		c.setCustomerId(1);
		Mockito.when(iTripBookingRepository.findById(1)).thenReturn(Optional.of(c));
		Assertions.assertDoesNotThrow(() -> iTripBookingService.deleteTripBooking(c));
	}
	
	/*@Test
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
