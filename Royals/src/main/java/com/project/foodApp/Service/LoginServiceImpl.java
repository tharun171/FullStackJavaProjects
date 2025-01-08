package com.project.foodApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodApp.BusinessBeans.UserBean;
import com.project.foodApp.Dao.LoginDaoImpl;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDaoImpl dao;

	@Override
	public boolean checkPhoneNumber(String phoneNumber) throws Exception {
		return dao.checkPhoneNumber(phoneNumber);
	}

	@Override
	public Integer sendOtp() throws Exception {
		return dao.sendOtp();
	}

	@Override
	public boolean verifyOtp(Integer userOtp) throws Exception {
		return dao.verifyOtp(userOtp);
	}

	@Override
	public boolean checkPhoneNumberInDB(String phoneNumber) throws Exception {
		return dao.checkPhoneNumberInDB(phoneNumber);
	}

	@Override
	public UserBean getUserDetailsByPhoneNumber(String PhoneNumber) throws Exception {
		return dao.getUserDetailsByPhoneNumber(PhoneNumber);
	}

	
}
