package com.project.foodApp.BusinessBeans;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public class otpLogging {
	
	@NotNull
	@Range(min=000000,max=999999)
	private Integer otpCheck;

	public Integer getOtpCheck() {
		return otpCheck;
	}

	public void setOtpCheck(Integer otpCheck) {
		this.otpCheck = otpCheck;
	}

	@Override
	public String toString() {
		return "otpLogging [otpCheck=" + otpCheck + "]";
	}
	
	

	

}
