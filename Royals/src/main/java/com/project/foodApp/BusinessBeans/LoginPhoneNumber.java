package com.project.foodApp.BusinessBeans;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//this POJO is used to check whether given phone number is valid or not

public class LoginPhoneNumber {

	@NotEmpty
	@Size(min=10)
	private String phoneNumber;
	
	private String error;
	
	public LoginPhoneNumber()
	{
		
	}
	public LoginPhoneNumber(String error)
	{
		this.error=error;
	}
	
	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Login [phoneNumber=" + phoneNumber + ", error=" + error + "]";
	}
	
}
