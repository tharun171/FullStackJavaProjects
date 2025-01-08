package com.project.foodApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodApp.BusinessBeans.SignUpBean;
import com.project.foodApp.Dao.SignUpDao;

@Service
public class SignUpServiceImpl implements SignUpService{

	@Autowired
	private SignUpDao signUpDao;
	
	@Override
	public boolean checkUserAlreadyExists(SignUpBean signUpDetails) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside signupService impl");
		return signUpDao.checkUserAlreadyExists(signUpDetails);
	}

	@Override
	public void createAccount(SignUpBean signUpDetails) throws Exception {
		// TODO Auto-generated method stub
		signUpDao.createAccount(signUpDetails);
	}

}
