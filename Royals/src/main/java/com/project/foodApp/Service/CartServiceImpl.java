package com.project.foodApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.foodApp.Dao.CartDao;
import com.project.foodApp.Entities.UserEntityCart;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartDao;

	@Override
	public Integer ItemsInCart(int id) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.ItemsInCart(id);
	}

	@Override
	public List<Integer> getCartItems(int id) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getCartItems(id);
	}

	@Override
	public List<Integer> updateCart(Integer id,List<Integer> toAddItems) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id,toAddItems);
	}

	@Override
	public List<Integer> removeItem(Integer userId,Integer id, List<Integer> updatedList) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.removeItem(userId,id, updatedList);
	}

	@Override
	public String addAddress(Integer userId,String address) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.addAddress(userId,address);
	}

	@Override
	public String getAddress(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getAddress(userId);
	}

	@Override
	public String getAllAddress(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getAllAddress(userId);
	}

	@Override
	public void setAllAddress(Integer userId,String addresses) throws Exception {
		// TODO Auto-generated method stub
		cartDao.setAllAddress(userId,addresses);
	}

	@Override
	public String setAddress(Integer userId, String address) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.setAddress(userId, address);
	}

	@Override
	public UserEntityCart getAddressInObject(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.getAddressInObject(userId);
	}

}
