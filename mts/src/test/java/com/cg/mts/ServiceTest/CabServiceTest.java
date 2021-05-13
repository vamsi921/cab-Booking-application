package com.cg.mts.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.Entity.Cab;
import com.cg.mts.repository.CabRepository;
import com.cg.mts.service.ICabService;
import com.sun.el.stream.Optional;

@SpringBootTest
public class CabServiceTest {
	
	

		@Autowired
		ICabService iCabService;
		
		@MockBean
		CabRepository iCabRepository;
		
		/*	@Test
		public void insertCabservice() 
		{
			Cab c = new Cab();
			c.setCabId(516);
			c.setCarType("fb");
			c.setPerKmRate(20);
			when(iCabRepository.save(c)).thenReturn(c);
		}*/
		
		@Test
		public void updateCabservice() 
		{
			java.util.Optional<Cab> service = iCabRepository.findById(515);
			if(service.isPresent()) 
			{
				service.get().setCarType("sr");
				iCabRepository.save(service.get());	
			}
			java.util.Optional<Cab> updatedCabservice = iCabRepository.findById(515);
			if(updatedCabservice.isPresent()) 
			{
				assertThat(updatedCabservice.get().getCarType().equals("sr"));
			}
		}
	
/*		@Test
		public void removeCabservice() 
		{
			Cab c = new Cab();
			c.setCabId(516);
			Mockito.when(iCabRepository.findById(516)).thenReturn(Optional.of(c));
			Assertions.assertDoesNotThrow(() -> iCabService.deleteCab(c));
		}*/
}
