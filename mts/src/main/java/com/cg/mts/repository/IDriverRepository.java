package com.cg.mts.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mts.Entity.Driver;
import com.cg.mts.Exception.DriverNotFoundException;
import com.cg.mts.dao.IAdminDao;
import com.cg.mts.dao.IDriverDao;

@Repository("dDao")
public interface IDriverRepository extends IDriverDao,JpaRepository<Driver, Integer>{

/*	@Query("SELECT d From Driver d WHERE d.rating >= 4.5")
	public List<Driver>viewBestDrivers() throws DriverNotFoundException ;
	
	@Query("INSERT INTO Customer")
	public Driver insertDriver(Driver driver);
	
	@Query("SELECT d From driver d WHERE driverId=null")
	public Driver viewDriver(int driverId)throws DriverNotFoundException;
	
	@Query("UPDATE INTO Driver")
	public Driver updateDriver(Driver driver)throws DriverNotFoundException;
	
	//public Driver deleteDriver(int driverId)throws DriverNotFoundException;




	@Query("SELECT e FROM AbstractUser e WHERE e.username=?1")
	public Optional<Driver> findByUsername(String username);
*/

}




