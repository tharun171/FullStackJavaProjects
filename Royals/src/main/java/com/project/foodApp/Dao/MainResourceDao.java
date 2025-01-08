package com.project.foodApp.Dao;

import java.util.List;

import com.project.foodApp.BusinessBeans.Item;

public interface MainResourceDao {

	List<Item> getBreakfast() throws Exception;
	
	List<Item> getPureVeg() throws Exception;
	
	List<Item> getRefreshments() throws Exception;
	
	List<Item> getStarters() throws Exception;
	
	List<Item> getPureNonVeg() throws Exception;
	
	List<Item> getDesserts() throws Exception;
	
	List<Item> getRoyalSpecials() throws Exception;
}
