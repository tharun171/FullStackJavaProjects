package com.project.foodApp.Dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.foodApp.BusinessBeans.SignUpBean;
import com.project.foodApp.BusinessBeans.UserBean;
import com.project.foodApp.Entities.UserEntity;
import com.project.foodApp.Entities.UserEntityCart;
import com.project.foodApp.Repositories.CartRepository;
import com.project.foodApp.Repositories.UserEntityId;
import com.project.foodApp.Repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;


@Repository
public class SignUpDaoImpl implements SignUpDao{
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CartRepository cartRepo;

	@Override
	public boolean checkUserAlreadyExists(SignUpBean signUpDetails) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside sign up dao impl....");
		System.out.println(signUpDetails.toString());
		em  = emf.createEntityManager();
		Query q = em.createNamedQuery("findPhoneNumberInDB",UserEntity.class);
		q.setParameter("userPhonenumber",signUpDetails.getPhoneNumber());
		try
		{
			UserEntity res = (UserEntity) q.getSingleResult();
			System.out.println(res.toString());
			return true;
		}
		catch(NoResultException e)
		{
			return false;
		}
	}

	@Override
	public void createAccount(SignUpBean signUpDetails) throws Exception {
		// TODO Auto-generated method stub
		em = emf.createEntityManager();
		UserEntity entity = new UserEntity(); 
		BeanUtils.copyProperties(signUpDetails,entity);
		entity.setJoinedDate(new Date());
		System.out.println("saving user into repo----->");
		//creating user details in database
		UserEntity entity1 = userRepo.save(entity);
		System.out.println(entity1.toString());
		//creating cart details
		UserEntityCart cart = new UserEntityCart();
		cart.setUserId(entity1.getUserId());
		cart.setItemsInCart(0);
		cart.setItemsSelected("");
		UserEntityCart cart1 =  cartRepo.save(cart);
		System.out.println(cart1.toString());
	}
	
	
	public void updateAccountDetails(UserBean user)
	{
		UserEntityId id = new UserEntityId();
		id.setUserId(user.getUserId());
		id.setPhoneNumber(user.getPhoneNumber());
		System.out.println("userEntityId "+id);
		Optional<UserEntity> userEntity = userRepo.findById(id);
		UserEntity userEntity1 = userEntity.get();
		
	}

	
}
