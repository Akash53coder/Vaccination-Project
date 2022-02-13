package com.xworkz.vaccine.controller;

import javax.servlet.http.HttpServletRequest;
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
		
	@RequestMapping("/login.vaccine")
	public String loginUser(@RequestParam String userName, @RequestParam String password, Model model,HttpServletRequest request) {
		boolean validated = this.loginService.validateLoginInfo(userName, password);
		if (validated) {
			LoginController.userName = userName;
			if (this.loginService.checkloginAttemptExceeded(userName)) {
				model.addAttribute("Login_Fail", "Your Account has Blocked, Please Reset Password");
				model.addAttribute("Show_Reset_Link", "true");
				return "Login";
			} else {
				if (this.loginService.verifyUser(userName, password)) {
					HttpSession session = request.getSession(true);
					session.setAttribute("userName", userName);
					model.addAttribute("userName", userName);
					return "HomePage";
				} else {
					if (this.loginService.loginAttemptExceeded(userName)) {
						model.addAttribute("Login_Fail", "Login Attempt Exceeded, Reset Password");
						model.addAttribute("Show_Reset_Link", "true");
						return "Login";
					}
					model.addAttribute("Login_Fail", "Invalid Credentials");
					return "Login";
				}
			}

		} else {
			model.addAttribute("Login_Fail", "Invalid Credentials");
			return "Login";
		}
	}

	@RequestMapping("/resetpasswordpage.vaccine")
	public String resetPasswordPageRedirect() {
		return "ResetPassword";
	}
	
	@RequestMapping("/loginpage.vaccine")
	public String loginPageRedirect() {
		return "Login";
	}
	

	@RequestMapping("/resetpassword.vaccine")
	public String resetPassword(@RequestParam String password, @RequestParam String confirmPassword, Model model) {
		if (this.loginService.validateResetPasswords(password, confirmPassword)) {
			if (this.loginService.resetPassword(password, userName)) {
				model.addAttribute("Password_Reset_Success", "Password Reset, Please Login!");
				model.addAttribute("login_link", "true");
				return "ResetPassword";
			}
			return "";
		} else {
			model.addAttribute("Password_Invalid", "Password Invalid");
			return "ResetPassword";
		}

	}
	
	@RequestMapping("/redirectlogin.vaccine")
	public String redirectToLogin() {
		return "Login";
	}
	
	@RequestMapping("/redirectaddmember.vaccine")
	public String redirectToAddMember() {
		return "AddMember";
	}

	@RequestMapping("/logout.vaccine")
	public String logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "Login";
	}
}
