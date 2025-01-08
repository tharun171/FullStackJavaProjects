package com.project.foodApp.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.foodApp.Entities.UserEntityCart;
import com.project.foodApp.Repositories.CartRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	private EntityManagerFactory emf;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Integer ItemsInCart(int id) throws Exception {
		Optional<UserEntityCart> userOptional = cartRepo.findById(id);
		UserEntityCart user = userOptional.get();
		Integer num = user.getItemsInCart();
		System.out.println(num);
		return num;
	}

	@Override
	public List<Integer> getCartItems(int id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in dao impl getcartItems");
		Optional<UserEntityCart> userOptional = cartRepo.findById(id);
		UserEntityCart user = userOptional.get();
		System.out.println("string format"+user.getItemsSelected());
		String s = user.getItemsSelected();
		List<Integer> l = new ArrayList<>();
		String str  = "";
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			int value = s.charAt(i);
			if(value>=48 && value<=57)
			{
				str=str+c;
				if(str.length()==6)
				{
					Integer val  = Integer.parseInt(str);
					l.add(val);
					str="";
				}
			}
		}
		System.out.println("list of items ids "+l);
		return l;
	}

	@Transactional
	@Modifying
	public List<Integer> updateCart(Integer id,List<Integer> toAddItems) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("in dao impl updation of items");
		
		Optional<UserEntityCart> userOptional = cartRepo.findById(id);
		UserEntityCart user = userOptional.get();
		
		System.out.println(user.toString());
		System.out.println("items to add into db "+toAddItems);
		
		int sizeOfCart = toAddItems.size();
		user.setItemsInCart(sizeOfCart);
		String itemsInCart = user.getItemsSelected();
		System.out.println(itemsInCart);
		user.setItemsSelected(toAddItems.toString());
		UserEntityCart user1 = cartRepo.save(user);
		System.out.println("afterr uppdation "+user1.toString());
		return toAddItems;
	}

	@Override
	public List<Integer> removeItem(Integer userId,Integer id, List<Integer> updatedList) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(id);
		updatedList.remove(id);
		Optional<UserEntityCart> userOptional = cartRepo.findById(userId);
		UserEntityCart user = userOptional.get();
		user.setItemsSelected(updatedList.toString());
		UserEntityCart user2 = cartRepo.save(user);
		System.out.println("removing id "+id);
		System.out.println("after removal "+user2.getItemsSelected());
		return updatedList;
	}

	@Override
	public String addAddress(Integer userId, String address) throws Exception {
		// TODO Auto-generated method stub
		Optional<UserEntityCart> userOptional = cartRepo.findById(userId);
		UserEntityCart user = userOptional.get();
		user.setAddress(address);
		String userAllAddress = user.getAlladdress();
		userAllAddress = userAllAddress + address +"&";
		user.setAlladdress(userAllAddress);
		UserEntityCart user2 = cartRepo.save(user);
		System.out.println(user2.toString());
		return user2.getAddress();
	}
	


	@Override
	public String getAddress(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Optional<UserEntityCart> user = cartRepo.findById(userId);
		UserEntityCart user2 = user.get();
		System.out.println(user2.getAddress());
		return user2.getAddress();
	}
	
	public UserEntityCart getAddressInObject(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Optional<UserEntityCart> user = cartRepo.findById(userId);
		UserEntityCart user2 = user.get();
		System.out.println(user2.getAddress());
		return user2;
	}

	@Override
	public String getAllAddress(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside getAllAddress");
		Optional<UserEntityCart> user = cartRepo.findById(userId);
		UserEntityCart user1 = user.get();
		String allAddress = user1.getAlladdress();
		if(allAddress==null)
		{
			allAddress="addresses not added!";
		}
		return allAddress;
	}

	@Override
	public void setAllAddress(Integer userId, String alladdresses) throws Exception {
		// TODO Auto-generated method stub
		Optional<UserEntityCart> userOptional = cartRepo.findById(userId);
		UserEntityCart user = userOptional.get();
		user.setAlladdress(alladdresses);
		UserEntityCart  user1  = cartRepo.save(user);
	}

	@Override
	public String setAddress(Integer userId, String address) throws Exception {
		// TODO Auto-generated method stub
		Optional<UserEntityCart> userOptional = cartRepo.findById(userId);
		UserEntityCart user = userOptional.get();
		user.setAddress(address);
		System.out.println("all addresss in db "+user.getAlladdress());
		UserEntityCart user1 = cartRepo.save(user);
		return user1.toString();
	}

}
