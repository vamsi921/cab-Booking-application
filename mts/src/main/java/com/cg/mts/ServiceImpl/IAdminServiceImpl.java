package com.cg.mts.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.Entity.Admin;
import com.cg.mts.Entity.TripBooking;
import com.cg.mts.Exception.CustomerNotFoundException;
import com.cg.mts.repository.IAdminRepository;
import com.cg.mts.service.IAdminService;


@Service("ias")
public class IAdminServiceImpl implements IAdminService{

	@Autowired
	IAdminRepository aDao;

	
	@Override
	public Admin insertAdmin(Admin admin) {
		aDao.save(admin);
		return admin;
	}

	@Override
	public List<Admin> viewALlAdmin() {
		return aDao.findAll();
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		aDao.save(admin);
		return admin;	
	}

	@Override
	public Admin deleteAdmin(int adminId) 
	{	
		Admin a = aDao.findById(adminId).get();
		aDao.deleteById(adminId);
		return a;
	}


	@Override
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException {
		return aDao.getAllTrips(customerId);
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		return aDao.getTripsCabwise();	
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		return aDao.getTripsCustomerwise();	
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		return aDao.getTripsDatewise();	
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) throws CustomerNotFoundException {
		return aDao.getAllTripsForDays(customerId, fromDate, toDate);
	}

	@Override
	public Admin getAdminById(int adminId) {
		return aDao.findById(adminId).get();
	}

}
