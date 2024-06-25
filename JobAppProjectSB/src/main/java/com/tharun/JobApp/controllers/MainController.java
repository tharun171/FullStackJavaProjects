package com.tharun.JobApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tharun.JobApp.BusinessBeans.JobPost;
import com.tharun.JobApp.ServiceDTO.JobService;

@Controller
public class MainController {
	
	@Autowired
	JobService service;

	ModelAndView mav = null;
	
	@GetMapping({"/","/home"})
	public ModelAndView getHomePage()
	{
		System.out.println("in controller");
		mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
	@GetMapping("/viewalljobs")
	public ModelAndView viewAllJobs()
	{
		mav = new ModelAndView();
		mav.setViewName("viewAllJobs");
		mav.addObject("jobPosts",service.getAllJobPosts());
		return mav;
	}
	
	@GetMapping("/addjob")
	public ModelAndView addJob()
	{
		mav = new ModelAndView();
		mav.setViewName("addNewJob");
		mav.addObject("jobPost",new JobPost());
		return mav;
	}
	
	@PostMapping("handleForm")
	public ModelAndView afterAddJobClicked(@ModelAttribute("jobPost") JobPost job)
	{
		mav = new ModelAndView();
		mav.addObject("jobPost",job);
		service.addJobPost(job);
		mav.setViewName("success");
		return mav;
				
	}
}
