package com.project.foodApp.BusinessBeans;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SignUpBean {
	
	private final long maxValue = 9999999999l;

	@NotEmpty
	@Size(min = 5,message="Name should be above 5 char long")
	private String name;
	@NotEmpty
	private String email;
	@NotNull
	@Max(value=maxValue,message="phoneNumber should be in 10 digits")
	private Long phoneNumber;
	@AssertTrue
	private boolean agreeMessages;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean isAgreeMessages() {
		return agreeMessages;
	}
	public void setAgreeMessages(boolean agreeMessages) {
		this.agreeMessages = agreeMessages;
	}
	@Override
	public String toString() {
		return "SignUpBean [maxValue=" + maxValue + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", agreeMessages=" + agreeMessages + "]";
	}
	
	
	
	
	
	
	

	
	
	
	
}
