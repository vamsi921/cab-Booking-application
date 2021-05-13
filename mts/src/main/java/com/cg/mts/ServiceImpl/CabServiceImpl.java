package com.cg.mts.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.mts.Entity.Cab;

import com.cg.mts.Exception.CabNotFoundException;
import com.cg.mts.repository.CabRepository;
import com.cg.mts.service.ICabService;


@Service
@Transactional
public class CabServiceImpl implements ICabService{
	

	CabServiceImpl(){
		System.out.println("Cab is been created");
	}

	@Autowired
	private CabRepository iCabRepository;

		
	@Override
	public Cab insertCab(Cab cab) 
	{

		iCabRepository.save(cab);
		return cab;
	}



	@Override
	public Cab updateCab( Cab cab)throws CabNotFoundException
	{
		int id = cab.getCabId();
		Cab existingCab = iCabRepository.findById(id).get();
		if(existingCab == null){
			throw new  CabNotFoundException("Customer Not Found");
		}
		else 
			BeanUtils.copyProperties(cab, existingCab, "id");
		return iCabRepository.save(existingCab);
	}

	@Override
	public Cab deleteCab( Cab cab) throws  CabNotFoundException
	{
		Cab cust= iCabRepository.findById(cab.getCabId()).get();
		if(cust == null)
		{
			throw new  CabNotFoundException("Cab Not Found");
		}
		else
		{
			iCabRepository.deleteById(cust.getCabId());
			return cust; 
		}
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException {
		List<Cab> cabList = (iCabRepository).findByCarType(carType);
		List<Cab> cabdList = new ArrayList<>();
		
		if (!cabList.isEmpty()) { 
			for (Cab c : cabList)
				cabdList.add(c);
		}
		else {
			throw new CabNotFoundException("cab not found");
		}
		return cabdList;	
	
	}
	
	@Override
	public int countCabsOfType(String carType) throws CabNotFoundException{
		long count = iCabRepository.countByCarType(carType);
		int cabCount =(int)count;
		return cabCount;
	}
	
}