package com.cg.mts.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.Entity.TripBooking;
import com.cg.mts.repository.ITripBookingRepository;
import com.cg.mts.service.ITripBookingService;

@Service
public class ITripBookingServiceImpls implements ITripBookingService{

	@Autowired
	ITripBookingRepository tripRepo;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		tripRepo.save(tripBooking);
		return tripBooking;
	}	

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		tripRepo.saveAndFlush(tripBooking);
		return tripBooking;
	}

	@Override
	public TripBooking deleteTripBooking(TripBooking tripBooking) {
		tripRepo.deleteById(tripBooking.getTripBookingId());		
		return tripBooking;
	}

	@Override
	public List<TripBooking> ViewAllTripsCustomer(int customerId) {
		List<TripBooking>list=tripRepo.findAllById(customerId);
		return list;
	}

	@Override
	public TripBooking calculateBill(TripBooking tripbooking){
   		float bill = tripbooking.getDistanceInKm() * tripbooking.getDriver().getCab().getPerKmRate();
   		tripbooking.setBill(bill);
   	    return tripbooking;
   	}

	

}
