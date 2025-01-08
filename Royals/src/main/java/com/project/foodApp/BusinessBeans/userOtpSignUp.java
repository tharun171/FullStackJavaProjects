package com.project.foodApp.BusinessBeans;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public class userOtpSignUp {

	@NotNull
	@Range(min=000000,max=999999)
	private Integer userOtp;

	public Integer getUserOtp() {
		return userOtp;
	}

	public void setUserOtp(Integer userOtp) {
		this.userOtp = userOtp;
	}

	@Override
	public String toString() {
		return "userOtpBean [userOtp=" + userOtp + "]";
	}
	
	
}
