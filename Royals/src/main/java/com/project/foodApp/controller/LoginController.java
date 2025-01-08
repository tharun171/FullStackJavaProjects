package com.project.foodApp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.project.foodApp.BusinessBeans.LoginPhoneNumber;
import com.project.foodApp.BusinessBeans.UserBean;
import com.project.foodApp.BusinessBeans.otpLogging;
import com.project.foodApp.Entities.UserEntity;
import com.project.foodApp.Entities.UserEntityCart;
import com.project.foodApp.Repositories.CartRepository;
import com.project.foodApp.Service.LoginService;
import com.project.foodApp.Service.LoginServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({"loginBean","otpBean","items"})
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	CartRepository cartRepo;

	ModelAndView mav = null;

	//mapping goes to home root
	//home root
	@GetMapping({"/","/home"})
	@ModelAttribute("loginBean")
	public ModelAndView home()
	{
		System.out.println("inside controller");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("loginBean",new LoginPhoneNumber());
		mav.addObject("otpBean",new otpLogging());
		return mav;
	}
	
	//checking whether entered phone number is valid or not
	@PostMapping("/phonenumberOtpCheck")
	public ModelAndView phonenumberOtpCheck(@ModelAttribute("loginBean") @Valid  LoginPhoneNumber lb,BindingResult res) throws Exception
	{
		System.out.println("inside phonenumberOtpCheck Api");
		System.out.println("ERRORS  "+res.hasErrors());
		System.out.println(service.checkPhoneNumber(lb.getPhoneNumber()));
		if(res.hasErrors())
		{
			System.out.println("HAS EROORS IN LOGIN");
			mav = new ModelAndView();
			mav.setViewName("home");
			mav.addObject("loginBean",new LoginPhoneNumber());
			mav.addObject("otpBean",new otpLogging());
			mav.addObject("errormessage","Enter Valid PhoneNumber!!!");
		}
		//checking phoneNumber length is 10 and doesnt not contain chars and symbols
		//else if(lb.checkPhoneNum(lb.getPhoneNumber())==false)
		else if(service.checkPhoneNumber(lb.getPhoneNumber())==false)
		{
			System.out.println("HAS EROORS IN LOGIN");
			mav = new ModelAndView();
			mav.setViewName("home");
			mav.addObject("loginBean",lb);
			mav.addObject("otpBean",new otpLogging());
			mav.addObject("errormessage","Enter Valid PhoneNumber!!!");
		}
		//check phone number is in database in not
		//if not there in database ask them to create an account
		else if(service.checkPhoneNumberInDB(lb.getPhoneNumber())==false)
		{
			System.out.println("you dont have an account");
			mav = new ModelAndView();
			mav.setViewName("home");
			mav.addObject("loginBean",lb);
			mav.addObject("otpBean",new otpLogging());
			mav.addObject("errormessage","Number Not Registered! SIGN UP!!!");
		}
		//else send them otp
		else
		{
			System.out.println("result "+lb.toString());
			mav = new ModelAndView();
			mav.addObject("successmessage","OTP SENT!!!");
			System.out.println("OTP is  ---------->"+service.sendOtp());
			mav.addObject("loginBean",lb);
			mav.addObject("otpBean",new otpLogging());
			mav.setViewName("home");
		}
		return mav;
	}
	
	//checking whether entered Otp is correct or not
	@PostMapping("/otpCheck")
	public ModelAndView OtpCheck(@ModelAttribute("otpBean") @Valid otpLogging ovb,BindingResult res,
			@ModelAttribute("loginBean") LoginPhoneNumber lb,
			RedirectAttributes redirectAttributes) throws Exception
	{
		System.out.println("inside otpCheck Api");
		if(res.hasErrors())
		{
			System.out.println("HAS EROORS IN OTP");
			mav = new ModelAndView();
			mav.setViewName("home");
			System.out.println(lb.toString()+" "+ovb.toString());
			mav.addObject("loginBean",lb);
			mav.addObject("otpBean",ovb);
			mav.addObject("errormessage","Enter Valid OTP!!!");
		}
		else
		{
			mav = new ModelAndView();
			//service.verifyOtp we send our otp to dao to verify
			System.out.println(service.verifyOtp(ovb.getOtpCheck()));
			if(service.verifyOtp(ovb.getOtpCheck())==true)
			{
				//containes user details associated with phone number
				UserBean e = service.getUserDetailsByPhoneNumber(lb.getPhoneNumber());
				System.out.println(e.toString());
				//for redirecting to another controller
				//we cant use session attributes to send data from one controller 
				//to another controller so we use flashAttributes to store data
				//and to redirect we use 
				redirectAttributes.addFlashAttribute("accountDetails", e);
				redirectAttributes.addFlashAttribute("username",e.getName());
				redirectAttributes.addFlashAttribute("userId",e.getUserId());
				
				//to get Items in Cart (size)
				//by default in database every user created will have 0 items , check db
				Optional<UserEntityCart> cartOptional = cartRepo.findById(e.getUserId());
				UserEntityCart userCart = cartOptional.get();
				int noOfItemsInCart  = userCart.getItemsInCart();
				
				String items = userCart.getItemsSelected();
				
				redirectAttributes.addFlashAttribute("itemsInCart",noOfItemsInCart);
				redirectAttributes.addFlashAttribute("items",items);
				
				String newPageUrl = e.getUserId() + "/main";
				//sending valid users to main page that have items
	            return new ModelAndView("redirect:" + newPageUrl);
	            //this is wrong
				//return new ModelAndView(newPageUrl);
			}
			else
			{
				mav.setViewName("home");
				System.out.println(lb.toString()+" "+ovb.toString());
				mav.addObject("loginBean",lb);
				mav.addObject("otpBean",ovb);
				mav.addObject("errormessage","Incorrect OTP!");
			}
			System.out.println(ovb.toString());
		}
		return mav;
	}
	
}
