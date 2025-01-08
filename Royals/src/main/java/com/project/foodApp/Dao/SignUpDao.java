package com.project.foodApp.Dao;

import com.project.foodApp.BusinessBeans.SignUpBean;

public interface SignUpDao {

	boolean checkUserAlreadyExists(SignUpBean signUpDetails)throws Exception;
	
	void createAccount(SignUpBean signUpDetails) throws Exception;
}
