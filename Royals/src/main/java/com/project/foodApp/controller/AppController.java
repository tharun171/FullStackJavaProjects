package com.project.foodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;


@Controller
@SessionAttributes({"textData"})
public class AppController {

	ModelAndView mav;
	
	@Autowired
	HttpSession sess;

	  @GetMapping("/data")
	  public ModelAndView showView(@RequestParam List<Integer> textData,RedirectAttributes redirectAttributes) {
	    System.out.println("inside rest api");
	    // Perform operations with the received text data
	    System.out.println("Received text data: " + textData);
	    redirectAttributes.addFlashAttribute("textData",textData);
	    sess.setAttribute("textData",textData);
	    String newPageUrl = "/cart";
	    // Generate the HTML for the view
	   return new ModelAndView("redirect:"+newPageUrl);
	  }

	}