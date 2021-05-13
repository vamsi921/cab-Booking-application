package com.cg.mts.service;

import java.util.List;

import com.cg.mts.Entity.Cab;

import com.cg.mts.Exception.CabNotFoundException;

public interface ICabService {
	public Cab insertCab(Cab cab) ;
	public Cab updateCab(Cab cab) throws CabNotFoundException ;
	public Cab deleteCab(Cab cab) throws CabNotFoundException;
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
	public int countCabsOfType(String carType) throws CabNotFoundException;
}