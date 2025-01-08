package com.project.foodApp.Dao;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodApp.BusinessBeans.UserBean;
import com.project.foodApp.Entities.UserEntity;
import com.project.foodApp.Repositories.UserEntityId;
import com.project.foodApp.Repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;


@Repository
public class LoginDaoImpl implements LoginDao{

	public List<Integer> storingOtp = new ArrayList<Integer>();
	
	@Autowired
	private EntityManager em;
	@Autowired
	private EntityManagerFactory emf;
	@Autowired
	private UserRepository repo;
	
	@Override
	public boolean checkPhoneNumber(String phoneNumber) throws Exception {
		// TODO Auto-generated method stub
		boolean bool;
		System.out.println(phoneNumber.length());
		int c = 0;
		if(phoneNumber.length()>=11)
		{
			bool = false;
		}
		else
		{
			for(int i=0;i<phoneNumber.length();i++)
			{
				int value = phoneNumber.charAt(i);
				if(value>=48 && value<=57)
				{
					c=c+1;
				}
			}
			System.out.println("c value"+c);
			if(c==10)
			{
				System.out.println("phoone num"+phoneNumber);
				bool = true;
			}
			else
			{
				bool = false;
			}
		}
		return bool;
	}

	@Override
	public Integer sendOtp() throws Exception {
		// Generating random 6 digit otp
		final int sendingOtp;
		double pin = (Math.random())*999999;
		sendingOtp = (int)pin;
		System.out.println(storingOtp);
		if(sendingOtp>=100000)
		{
			if(storingOtp.contains(sendingOtp))
			{
				System.out.println("OTP already exists");
				sendOtp();
			}
			else
			{
				storingOtp.add(sendingOtp);
				System.out.println(storingOtp);
			}
		}
		else
		{
			sendOtp();
		}
		return sendingOtp;
	}

	@Override
	public boolean verifyOtp(Integer userOtp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("userotp "+userOtp);
		System.out.println("index of last stored in list ");
		System.out.println(storingOtp.size()-1);
		System.out.println(storingOtp.get(storingOtp.size()-1));
		Integer lastOtpSent = storingOtp.get(storingOtp.size()-1);
		if(userOtp.equals(lastOtpSent))
		{
			System.out.println("otp matched");
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean checkPhoneNumberInDB(String phoneNumber) throws Exception {
		// TODO Auto-generated method stub
		Long phone = Long.parseLong(phoneNumber);
		em = emf.createEntityManager();
		try
		{
			Query q = em.createNamedQuery("findPhoneNumberInDB",UserEntity.class);
			q.setParameter("userPhonenumber",phone);
			UserEntity entity = (UserEntity) q.getSingleResult();
			System.out.println(entity.toString());
			return true;
		}
		catch(NoResultException e)
		{
			return false;
		}
	}

	@Override
	public UserBean getUserDetailsByPhoneNumber(String PhoneNumber) throws Exception {
		UserBean uBean = new UserBean();
		Long phone = Long.parseLong(PhoneNumber);
		em = emf.createEntityManager();
		Query q = em.createNamedQuery("findPhoneNumberInDB",UserEntity.class);
		q.setParameter("userPhonenumber",phone);
		UserEntity user = (UserEntity) q.getSingleResult();
		System.out.println(user.toString());
		BeanUtils.copyProperties(user,uBean);
		return uBean;
	}

}
