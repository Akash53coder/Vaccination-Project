package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login.vaccine")
	public String loginUser(@RequestParam String userName, @RequestParam String password,Model model) {
		boolean validated = this.loginService.validateLoginInfo(userName, password);
		if(validated) {
			if(this.loginService.verifyUser(userName, password)) {
				return "/WEB-INF/pages/HomePage.jsp";
			}else {
				if(this.loginService.loginAttemptExceeded(userName)) {
					model.addAttribute("Login_Fail", "Login Attempt Exceeded, Account Blocked");
					return "/WEB-INF/pages/Login.jsp";
				}
				model.addAttribute("Login_Fail", "Invalid Credentials");
				return "/WEB-INF/pages/Login.jsp";			
			}
		}else {
			model.addAttribute("Login_Fail", "Invalid Credentials");
			return "/WEB-INF/pages/Login.jsp";			
		}
	}

}
