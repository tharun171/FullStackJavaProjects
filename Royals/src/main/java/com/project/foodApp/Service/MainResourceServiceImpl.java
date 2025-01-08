package com.project.foodApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.foodApp.BusinessBeans.Item;
import com.project.foodApp.Dao.MainResourceDao;

@Service
public class MainResourceServiceImpl implements MainResourceService{

	@Autowired
	MainResourceDao dao;
	
	@Override
	public List<Item> getBreakfast() throws Exception {
		// TODO Auto-generated method stub
		return dao.getBreakfast();
	}

	@Override
	public List<Item> getPureVeg() throws Exception {
		// TODO Auto-generated method stub
		return dao.getPureVeg();
	}

	@Override
	public List<Item> getRefreshments() throws Exception {
		// TODO Auto-generated method stub
		return dao.getRefreshments();
	}

	@Override
	public List<Item> getStarters() throws Exception {
		// TODO Auto-generated method stub
		return dao.getStarters();
	}

	@Override
	public List<Item> getPureNonVeg() throws Exception {
		// TODO Auto-generated method stub
		return dao.getPureNonVeg();
	}

	@Override
	public List<Item> getDesserts() throws Exception {
		// TODO Auto-generated method stub
		return dao.getDesserts();
	}

	@Override
	public List<Item> getRoyalSpecials() throws Exception {
		// TODO Auto-generated method stub
		return dao.getRoyalSpecials();
	}

}
