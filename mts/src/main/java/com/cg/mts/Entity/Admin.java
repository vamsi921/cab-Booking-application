package com.cg.mts.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
public class Admin extends AbstractUser {
	@Id
	@GeneratedValue ( strategy =  GenerationType.IDENTITY)
	private int adminId;

	public Admin() {
		super();
	}

	public Admin(int adminId) {
		super();
		this.adminId = adminId;
	}
	
	@NotNull
//	@Size(min=1,message="admin id must contain atleast 1 digit")
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
}