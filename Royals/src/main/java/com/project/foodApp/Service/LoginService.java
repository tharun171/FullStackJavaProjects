package com.project.foodApp.Service;

import com.project.foodApp.BusinessBeans.UserBean;

public interface LoginService {

	boolean checkPhoneNumber(String phoneNumber) throws Exception;
	
	Integer sendOtp() throws Exception;
	
	boolean verifyOtp(Integer userOtp) throws Exception;
	
	boolean checkPhoneNumberInDB(String phoneNumber) throws Exception;
	
	UserBean getUserDetailsByPhoneNumber(String PhoneNumber) throws Exception;
}
