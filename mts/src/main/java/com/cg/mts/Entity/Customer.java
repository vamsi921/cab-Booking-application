package com.cg.mts.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends AbstractUser {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_Id")
	private int customerId;
	
	/*@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private TripBooking tripBooking;*/

	public Customer() {
		super();
	}

	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
