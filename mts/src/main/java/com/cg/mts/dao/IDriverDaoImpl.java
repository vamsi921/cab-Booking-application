package com.cg.mts.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cg.mts.Entity.Driver;

public class IDriverDaoImpl  implements IDriverDao{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Driver>viewBestDrivers(){
		TypedQuery<Driver> q = em.createQuery("select tb from Driver tb", Driver.class);

		List<Driver> result = q.getResultList();
		
		result.stream().filter((d) -> d.getRating() >= 4.5).collect(Collectors.toList());
				
		return result;
	}
	

}
