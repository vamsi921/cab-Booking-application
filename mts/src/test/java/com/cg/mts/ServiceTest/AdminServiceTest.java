package com.cg.mts.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.mts.Entity.Admin;
import com.cg.mts.repository.IAdminRepository;
import com.cg.mts.service.IAdminService;

import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	IAdminService a;
	
	@MockBean
	IAdminRepository arepo;
	
	//Insert 
	@Test
	public void insertAdminService() {
		Admin a = new Admin();
		
		a.setAdminId(1);
		a.setUsername("parth");
		a.setPassword("abcdefg");
		a.setMobileNumber("9403006155");
		a.setEmail("parthkothari11@gmail.com");

		when(arepo.saveAndFlush(a)).thenReturn(a);
				
	}
	
	//Get Admin By Id
	@Test
	public void getAdminServiceById() {
		Optional<Admin> service = arepo.findById(1);;
		if(service.isPresent()) {
			assertEquals(service.get().getAdminId(), 1);
		}
	}

	
	//Update Admin
	@Test
	public void updateAdminservice() {
		Optional<Admin> service = arepo.findById(1);
		if(service.isPresent()) {
			service.get().setUsername("parth");
			arepo.save(service.get());	
		}
		Optional<Admin> updatedadminservice = arepo.findById(1);
		if(updatedadminservice.isPresent()) {
			assertThat(updatedadminservice.get().getUsername().equals("parth"));
		}
	}
	
	
	//View All Admin
	@Test
	public void getAllAdminservice() {
		Mockito.when(arepo.findAll())
				.thenReturn(java.util.stream.Stream.of(new Admin(),new Admin()).collect(Collectors.toList()));
		
		assertEquals(2, a.viewALlAdmin().size());
		verify(arepo, times(1)).findAll();
		
	}
	
	public void deleteAdminservice() {
		int adminId = 1;
		a.deleteAdmin(adminId);
		
		verify(arepo, times(1)).deleteById(adminId);
	}

	
}
