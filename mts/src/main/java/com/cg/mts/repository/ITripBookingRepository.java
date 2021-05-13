package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mts.Entity.TripBooking;

@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking,Integer>{

	@Query("SELECT tb FROM TripBooking tb WHERE tb.customerId=?1")
	 List<TripBooking> findAllById(int customerId);

}
