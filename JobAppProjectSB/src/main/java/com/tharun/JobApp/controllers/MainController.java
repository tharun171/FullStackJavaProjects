package com.tharun.JobApp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tharun.JobApp.BusinessBeans.JobPost;
import com.tharun.JobApp.ServiceDTO.JobService;

import jakarta.servlet.http.HttpSession;


@Controller
//@RestController
@SessionAttributes("jobPostUpdate")
public class MainController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JobService service;

	ModelAndView mav = null;
	
	@GetMapping({"/","/home"})
	public ModelAndView getHomePage()
	{
		log.info("--> in getHomePage Controller method");
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
		mav.addObject("jobPost1",new JobPost());
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
	
	@PostMapping("/handleForm")
	public ModelAndView afterAddJobClicked(@ModelAttribute("jobPost") JobPost job)
	{
		mav = new ModelAndView();
		mav.addObject("jobPost",job);
		//checks whether id exist or not
		//if yes will update it, else adds it
		service.addJobPost(job);
		mav.setViewName("success");
		return mav;		
	}
	
	@PostMapping("/delete")
	public String deleteMethod(@ModelAttribute("jobPost1") JobPost jobpost)
	{
		log.info("--> in deleteMethod Controller method");;
		Integer deleteId = jobpost.getPostId();
		log.info("-->Id to be deleted is : "+deleteId);
		String deletionStatus = service.deleteJobPost(deleteId);
		log.info("--> deletion Status is: "+deletionStatus);
		mav = new ModelAndView();
		return "redirect:/viewalljobs";
	}
	
	@PostMapping("/update")
	public ModelAndView updateMethod(@ModelAttribute("jobPost") JobPost jobPost,
			HttpSession session) {
	    log.info("--> in updateMethod Controller");
	    log.info("--> data: " + jobPost.toString());
	    Integer updateId = jobPost.getPostId();
	    JobPost existingDetails = service.getJobPost(updateId);
	    mav = new ModelAndView();
	    mav.addObject("jobPost", existingDetails); // Ensure consistency in attribute names
	    mav.setViewName("addNewJob");
	    return mav;
	}
}
