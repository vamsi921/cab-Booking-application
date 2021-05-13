package com.cg.mts.ServiceTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.Entity.Driver;
import com.cg.mts.repository.IDriverRepository;
import com.cg.mts.service.IDriverService;
@SpringBootTest
public class DriverServiceTest {
	
	

		@Autowired
		IDriverService idriverService;
		
		@MockBean
		IDriverRepository idriverRepository;
		
		@Test
		public void insertDriverservice() 
		{
			Driver d = new Driver();
			d.setDriverId(123);
			d.setLicenseNo("abc");
			d.setRating(5);
			d.setEmail("ajith@gmail.com");
			d.setMobileNumber("9876543210");
			d.setPassword("aji");
			d.setUsername("ajith");
//			d.setAddress("Hydernagar");
			when(idriverRepository.save(d)).thenReturn(d);
		}
		
		@Test
		public void updateDriverservice() 
		{
			Optional<Driver> service = idriverRepository.findById(123);
			if(service.isPresent()) 
			{
				service.get().setUsername("ajithvamsi");
				idriverRepository.save(service.get());	
			}
			Optional<Driver> updateddriverservice = idriverRepository.findById(123);
			if(updateddriverservice.isPresent()) 
			{
				assertThat(updateddriverservice.get().getUsername().equals("ajithvamsi"));
			}
		}
		
		/*@Test
		public void viewDriverServiceById()
		{
			Optional<Driver> oc = idriverRepository.findById(123);
			if(oc.isPresent()) 
			{
				assertEquals(oc.get().getDriverId(),123);
			}
		}
	

	@Test
		public void removeDriverservice() 
		{
			Driver c = new Driver();
			c.setDriverId(1);
			Mockito.when(idriverRepository.findById(1)).thenReturn(Optional.of(c));
			Assertions.assertDoesNotThrow(() -> idriverService.deleteCustomer(c));
		}*/

}
