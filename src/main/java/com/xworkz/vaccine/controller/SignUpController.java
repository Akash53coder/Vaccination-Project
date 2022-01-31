package com.xworkz.vaccine.controller;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.UserSignUpDTO;
import com.xworkz.vaccine.service.SignUpService;

@Controller
@RequestMapping("/")
public class SignUpController {

	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	private RegisternOTPController otpController;
	
	public static String password;
		
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	    new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	
	@RequestMapping("/signup.vaccine")
	public String singUpUser(@ModelAttribute UserSignUpDTO signUpDTO , Model model) {		
		System.out.println("this is singupdata"+signUpDTO);
		SignUpController.password = signUpDTO.getPassword();
		boolean validated = this.signUpService.validateUserSignUp(signUpDTO);
		if(validated) {
			if(this.signUpService.saveSignUpInfo(signUpDTO)) {
				if(this.signUpService.sendSignupMail(this.otpController.getEmailId())) {					
					model.addAttribute("Signup_Succ_Msg", "Sign Up Successfull, A Mail Sent to Your MailId ");
					return "/WEB-INF/pages/Login.jsp";
				}else {
					model.addAttribute("Signup_Msg", "Sign Up Not Successfull");
					return "/WEB-INF/pages/Signup.jsp";
				}
				
			}else {
				model.addAttribute("Signup_Msg", "Sign Up Not Successful!!");
				return "/WEB-INF/pages/Signup.jsp";
			}
		}else {
			Map<String,String> map = this.signUpService.errorMap;
			model.addAttribute("NameNotValid", map.get("Name_Invalid"));
			model.addAttribute("PhoneNotValid", map.get("Phone_Invalid"));
			model.addAttribute("PasswordNotValid", map.get("Password_Invalid"));
			model.addAttribute("CpasswordNotValid", map.get("Confirm_Password_Invalid"));
			model.addAttribute("PasswordNotMatched", map.get("Password_Mismatch"));
			model.addAttribute("DobNotInvalid", map.get("DOB_Invalid"));
			model.addAttribute("GenderNotInvalid", map.get("Gender_Invalid"));
			return "/WEB-INF/pages/Signup.jsp";
		}
		
	}
	
}
