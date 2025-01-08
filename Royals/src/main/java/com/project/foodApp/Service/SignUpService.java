package com.project.foodApp.Service;

import com.project.foodApp.BusinessBeans.SignUpBean;

public interface SignUpService {

	boolean checkUserAlreadyExists(SignUpBean signUpDetails) throws Exception;
	
	void createAccount(SignUpBean signUpDetails) throws Exception;
}
