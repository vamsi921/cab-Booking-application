package com.cg.mts.Entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractUser {
	@NotNull
	@Size(min=4, message= "User name should contain atleast of 4 charecters")
	private String username;
	
	@NotNull
	@Size(min=6, message= "Password should contain atleast of 6 charecters")
	private String password;
	
	@NotNull
	@Size(min=10,max=10, message="mobile number must contain 10 digits")
	private String mobileNumber;
	
	@NotBlank
	@Email
	private String email;
	
	public AbstractUser() {
		super();
	}

	public AbstractUser(String username, String password, String mobileNumber, String email) {
		super();
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}