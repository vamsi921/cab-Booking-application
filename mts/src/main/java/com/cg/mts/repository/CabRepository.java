package com.cg.mts.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

import com.cg.mts.Entity.Cab;

import com.cg.mts.Exception.CabNotFoundException;
	@Repository
	public interface CabRepository extends JpaRepository<Cab, Integer> {
		
		@Query("SELECT e FROM Cab e WHERE e.carType=?1")
		List<Cab> findByCarType(String carType);

		long countByCarType(String carType);
         
		//int countByCarType(String carType) throws CabNotFoundException;
		
/*		@Query
		public Cab insertCab(Cab cab) throws CabAlreadyExistException;
		public Cab updateCab(Cab cab) throws CabNotFoundException;
		public Cab deleteCab(Cab cab) throws CabNotFoundException;
	*/	
		
		
	

}