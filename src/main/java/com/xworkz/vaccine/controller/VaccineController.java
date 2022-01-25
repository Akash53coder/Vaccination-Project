package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.VaccineService;

@Controller
@RequestMapping("/")
public class VaccineController {

	@Autowired
	private VaccineService vaccineService;

	@RequestMapping("/sendotpmail.vaccine")
	public String sendOTPMail(@RequestParam String emailId, Model model) {
		System.out.println("called sendRegistrationMail()");
		if (this.vaccineService.validateEmailId(emailId)) {
			int otp = this.vaccineService.getOTP();
			boolean isMailSent = this.vaccineService.sendOTPMail(emailId, otp);
			if (isMailSent) {
				boolean isSaved = this.vaccineService.saveOTPToDB(emailId, otp);
				if(isSaved) {
					System.out.println("OTP Data saved");
				}
				model.addAttribute("OTP_Sent", "OTP Has Sent to Your EmailId !!");
				return "/WEB-INF/pages/Verifyotp.jsp";
			} else {
				model.addAttribute("OTP_Not_Sent", "Sorry!! OTP Not Sent");
				return "/Register.jsp";
			}
		} else {
			model.addAttribute("Invalid_EmailId", "Invalid EmailId Entered");
			return "/Register.jsp";
		}
	}
	
	@RequestMapping("/verifyotp.vaccine")
	public String verifyOTP(@RequestParam Integer otp, Model model) {
		System.out.println("called verify otp()");
		if(this.vaccineService.validateVerifyOTP(otp)) {
			if(this.vaccineService.verifyOTP(otp)) {
				System.out.println("otp varified");
				model.addAttribute("OTP_Verified", "OTP Verified!!!");
				return "/WEB-INF/pages/Verifyotp.jsp";
			}else {
				model.addAttribute("OTP_Invalid", "Wrong OTP Entered!!!");
				return "/WEB-INF/pages/Verifyotp.jsp";
			}
			
		}else {
			model.addAttribute("OTP_Invalid", "Invalid OTP Entered!!!");
			return "/WEB-INF/pages/Verifyotp.jsp";
		}
		
	}

}
