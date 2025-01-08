package com.project.foodApp.Dao;

import com.project.foodApp.BusinessBeans.UserBean;

public interface LoginDao {

	boolean checkPhoneNumber(String phoneNumber) throws Exception;
	
	Integer sendOtp() throws Exception;
	
	boolean verifyOtp(Integer userOtp) throws Exception;
	
	boolean checkPhoneNumberInDB(String phoneNumber) throws Exception;
	
	UserBean getUserDetailsByPhoneNumber(String PhoneNumber) throws Exception;
}
