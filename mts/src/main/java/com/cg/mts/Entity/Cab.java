package com.cg.mts.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cab {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
//	@NotNull
//  @Size(min=5,max=5,message="cabId must contain 5 digits")
	private int cabId;
	@NotNull
    @Size(min=5,message="carType must contain 5 charecters")
	private String carType;
	@NotNull
    @NumberFormat
	private float perKmRate;
	@OneToOne(mappedBy = "cab", cascade = CascadeType.ALL)
	private Driver driver;
 
	public Cab() {
		super();
	}
	public Cab(int cabId, String carType, float perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
	}
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	
}