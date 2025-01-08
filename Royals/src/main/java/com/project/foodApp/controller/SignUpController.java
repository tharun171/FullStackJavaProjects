package com.project.foodApp.controller;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.project.foodApp.BusinessBeans.LoginPhoneNumber;
import com.project.foodApp.BusinessBeans.SignUpBean;
import com.project.foodApp.BusinessBeans.otpLogging;
import com.project.foodApp.BusinessBeans.userOtpSignUp;
import com.project.foodApp.Service.LoginServiceImpl;
import com.project.foodApp.Service.SignUpService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("signUpDetails")
public class SignUpController {
	
	@Autowired
	private LoginServiceImpl service;
	
	@Autowired
	private SignUpService signUpService;
	
	ModelAndView mav;
	
	@GetMapping("/signUp")
	public ModelAndView openSignUp()
	{
		System.out.println("inside royals/signup api");
		mav = new ModelAndView();
		mav.addObject("signUpMA",new SignUpBean());
		return mav;
	}
	
	
	//this is used to verify the user sign up details
	//if all the criteria met the redirected to verify phone number
	//else goes to same page with errors
	@PostMapping("/verifySignUpDetails")
	public ModelAndView verifySignUpDetails(@ModelAttribute("signUpMA") @Valid SignUpBean signUpDetails,
			BindingResult res) throws Exception
	{
		System.out.println("inside verifySignUpDetails api");
		boolean phoneNumberExistInDB = signUpService.checkUserAlreadyExists(signUpDetails);
		System.out.println("phoneNumberExistInDB "+phoneNumberExistInDB);
		if(res.hasErrors())
		{
			mav = new ModelAndView();
			mav.setViewName("signUp");
			mav.addObject("signUpDetails",signUpDetails);
			mav.addObject("signUpMA",signUpDetails);
			//mav.addObject("otpValidation",new userOtpSignUp());
			return mav;
		}
		// need to check here whether phonenumber are in database or not 
		//if exists throw error at same page and ask to login
		else if(phoneNumberExistInDB==true)
		{
			mav.setViewName("signUp");
			mav.addObject("signUpDetails",signUpDetails);
			mav.addObject("signUpMA",signUpDetails);
			//mav.addObject("otpValidation",new userOtpSignUp());
			mav.addObject("errormessage","phoneNumber already exist in database! Login!!!");
			return mav;
		}
		//else take them to verify phonenumber page
		else
		{
			mav = new ModelAndView();
			System.out.println("ERRORS -------------------> "+res.hasErrors());
			System.out.println("verifySignUpDetails api");
			System.out.println(signUpDetails.toString());
			mav.setViewName("verifySignUp");
			mav.addObject("signUpDetails",signUpDetails);
			mav.addObject("otpValidation",new userOtpSignUp());
			return mav;
		}
	}
	
	//this api will send the otp to the user after getting phoneNumber
	@PostMapping("/sendOtp")
	public ModelAndView sendOtp(@ModelAttribute("signUpDetails") SignUpBean signup) throws Exception
	{
		System.out.println(signup.toString());
		mav = new ModelAndView();
		mav.setViewName("verifySignUp");
		mav.addObject("signUpDetails",signup);
		mav.addObject("otpValidation",new userOtpSignUp());
		System.out.println("our otp --------> "+service.sendOtp());
		mav.addObject("successmessage","OTP SENT!");
		return mav;
	}
	
	//this api will check users otp and our otp
	@PostMapping("/verifyOtp")
	public ModelAndView verifyOtp(@ModelAttribute("otpValidation") userOtpSignUp otp,
			@ModelAttribute("signUpDetails") SignUpBean signup) throws Exception
	{
		System.out.println("user entered otp "+otp.getUserOtp());
		if(service.verifyOtp(otp.getUserOtp())==true)
		{
			System.out.println(signup.toString());
			mav.setViewName("home");
			LoginPhoneNumber lpn = new LoginPhoneNumber();
			lpn.setPhoneNumber(Long.toString(signup.getPhoneNumber()));
			mav.addObject("loginBean",lpn);
			mav.addObject("otpBean",new otpLogging());
			mav.addObject("errormessage","");
			mav.addObject("successmessage","Account Created, Login Here!");
			//signup is signupDetails
			signUpService.createAccount(signup);
		}
		else
		{
			mav.setViewName("verifySignUp");
			mav.addObject("signUpDetails",signup);
			mav.addObject("otpValidation",otp);
			mav.addObject("errormessage","Incorrect OTP!");
		}
		return mav;
	}

}
