package com.cg.mts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.mts.Entity.Driver;
import com.cg.mts.Exception.DriverNotFoundException;

@Service
public interface IDriverService {
	public Driver insertDriver(Driver driver);
	public Driver updateDriver(Driver driver);
	public Driver deleteDriver(int driverId);
	public List<Driver>viewBestDrivers();
	public Driver viewDriver(int driverId);
	
}
