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
	private RegisternOTPController otpController;

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login.vaccine")
	public String loginUser(@RequestParam String userName, @RequestParam String password, Model model) {
		boolean validated = this.loginService.validateLoginInfo(userName, password);
		if (validated) {
			if (this.loginService.checkloginAttemptExceeded(userName)) {
				model.addAttribute("Login_Fail", "Your Account has Blocked, Please Reset Password");
				model.addAttribute("Show_Reset_Link", "true");
				return "/WEB-INF/pages/Login.jsp";
			} else {
				if (this.loginService.verifyUser(userName, password)) {
					return "/WEB-INF/pages/HomePage.jsp";
				} else {
					if (this.loginService.loginAttemptExceeded(userName)) {
						model.addAttribute("Login_Fail", "Attempt Exceeded, Account Blocked. Reset Password");
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
			if (this.loginService.resetPassword(password, this.otpController.getEmailId())) {
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

}
