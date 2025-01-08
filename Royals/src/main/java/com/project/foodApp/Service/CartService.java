package com.project.foodApp.Service;

import java.util.List;

import com.project.foodApp.Entities.UserEntityCart;

public interface CartService {

	Integer ItemsInCart(int id) throws Exception;
	
	List<Integer> getCartItems(int id) throws Exception;
	
	List<Integer> updateCart(Integer id,List<Integer> toAddItems) throws Exception;
	
	List<Integer> removeItem(Integer userId,Integer id,List<Integer> updatedList) throws Exception;
	
	String addAddress(Integer userId,String address) throws Exception;
	
	String getAddress(Integer userId) throws Exception;
	
	String getAllAddress(Integer userId) throws Exception;
	
	void setAllAddress(Integer userId,String addresses) throws Exception;
	
	String setAddress(Integer userId,String address) throws Exception;
	
	UserEntityCart getAddressInObject(Integer userId) throws Exception;
}
