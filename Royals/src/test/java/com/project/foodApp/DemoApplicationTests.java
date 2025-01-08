package com.project.foodApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.foodApp.BusinessBeans.Item;
import com.project.foodApp.Service.MainResourceService;
import com.project.foodApp.controller.MainPageController;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	MainResourceService service;
	
	@Autowired
	MainPageController controller;

	@Test
	public void getItems() throws Exception
	{
		System.out.println(service.getBreakfast());
		List<Item> l = service.getBreakfast();
		Item l1= l.get(0);
		System.out.println("list "+l1.getNoOfPeopleOrdered());
		assertNotNull(service.getBreakfast());
	}
	

}
