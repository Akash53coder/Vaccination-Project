package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {

	@Autowired
	private RegisterService regService;

	@RequestMapping("/registervaccine.vaccine")
	public String sendRegistrationMail(@RequestParam String emailId, Model model) {
		System.out.println("called sendRegistrationMail()");
		if (this.regService.validateEmailId(emailId)) {
			int otp = this.regService.getOTP();
			boolean isMailSent = this.regService.sendOTPMail(emailId, otp);
			if (isMailSent) {
				model.addAttribute("OTP_Sent", "OTP Has Sent Your EmailId !!");
				return "/WEB-INF/pages/verifyotp.jsp";
			} else {
				model.addAttribute("OTP_Not_Sent", "Sorry!! OTP Not Sent");
				return "/register.jsp";
			}
		} else {
			model.addAttribute("Invalid_EmailId", "Invalid EmailId Entered");
			return "/register.jsp";
		}
	}

}
