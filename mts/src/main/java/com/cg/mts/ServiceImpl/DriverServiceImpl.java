package com.cg.mts.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.Entity.Admin;
import com.cg.mts.Entity.Driver;

import com.cg.mts.Exception.DriverNotFoundException;
import com.cg.mts.repository.IDriverRepository;
import com.cg.mts.service.IDriverService;

@Service
@Transactional
public class DriverServiceImpl implements IDriverService  { 
	
	
	@Autowired
	IDriverRepository idriverRepository;
	
	
	@Override
	public Driver insertDriver(Driver driver) 
	{
		idriverRepository.save(driver);
		return driver;
	}

	@Override
	public Driver updateDriver( Driver driver) throws DriverNotFoundException
	{
		int id = driver.getDriverId();
		Driver dc = idriverRepository.findById(id).get();
		if(dc == null)
			throw new  DriverNotFoundException("Driver Not Found");
		else
			return idriverRepository.save(driver);
	}

	@Override
	public Driver deleteDriver( int driverId) throws DriverNotFoundException
	{
		Driver dr= idriverRepository.findById(driverId).get();
		if(dr == null)
		{
			throw new  DriverNotFoundException("Driver Not Found");
		}
		else
		{
			idriverRepository.deleteById(dr.getDriverId());
			return dr; 
		}
	}

	@Override
	public List<Driver> viewBestDrivers() 
	{
		return idriverRepository.viewBestDrivers();
	}

	
	@Override
	public Driver viewDriver(int driverId) 
	{
		return idriverRepository.findById(driverId).get();
	}
	
}
