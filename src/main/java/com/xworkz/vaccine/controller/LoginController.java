package com.xworkz.vaccine.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xworkz.vaccine.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	public static String userName;

	@Autowired
	private LoginService loginService;
	
	public HttpSession session;
	
	@RequestMapping("/login.vaccine")
	public String loginUser(@RequestParam String userName, @RequestParam String password, Model model) {
		boolean validated = this.loginService.validateLoginInfo(userName, password);
		if (validated) {
			LoginController.userName = userName;
			if (this.loginService.checkloginAttemptExceeded(userName)) {
				model.addAttribute("Login_Fail", "Your Account has Blocked, Please Reset Password");
				model.addAttribute("Show_Reset_Link", "true");
				return "/WEB-INF/pages/Login.jsp";
			} else {
				if (this.loginService.verifyUser(userName, password)) {
					session.setAttribute("userName", LoginController.userName);
					model.addAttribute("userName", userName);
					return "/WEB-INF/pages/HomePage.jsp";
				} else {
					if (this.loginService.loginAttemptExceeded(userName)) {
						model.addAttribute("Login_Fail", "Login Attempt Exceeded, Reset Password");
						model.addAttribute("Show_Reset_Link", "true");
						return "/WEB-INF/pages/Login.jsp";
					}
					model.addAttribute("Login_Fail", "Invalid Credentials");
					return "/WEB-INF/pages/Login.jsp";
				}
			}

		} else {
			model.addAttribute("Login_Fail", "Invalid Credentials");
			return "/WEB-INF/pages/Login.jsp";
		}
	}

	@RequestMapping("/resetpasswordpage.vaccine")
	public String resetPasswordPageRedirect() {
		return "/WEB-INF/pages/ResetPassword.jsp";
	}
	
	@RequestMapping("/loginpage.vaccine")
	public String loginPageRedirect() {
		return "/WEB-INF/pages/Login.jsp";
	}
	

	@RequestMapping("/resetpassword.vaccine")
	public String resetPassword(@RequestParam String password, @RequestParam String confirmPassword, Model model) {
		if (this.loginService.validateResetPasswords(password, confirmPassword)) {
			if (this.loginService.resetPassword(password, userName)) {
				model.addAttribute("Password_Reset_Success", "Password Reset, Please Login!");
				model.addAttribute("login_link", "true");
				return "/WEB-INF/pages/ResetPassword.jsp";
			}
			return "";
		} else {
			model.addAttribute("Password_Invalid", "Password Invalid");
			return "/WEB-INF/pages/ResetPassword.jsp";
		}

	}
	
	@RequestMapping("/redirectlogin.vaccine")
	public String redirectToLogin() {
		return "/WEB-INF/pages/Login.jsp";
	}
	
	@RequestMapping("/redirectaddmember.vaccine")
	public String redirectToAddMember() {
		return "/WEB-INF/pages/AddMember.jsp";
	}

}
