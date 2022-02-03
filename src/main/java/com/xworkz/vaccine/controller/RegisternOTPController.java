package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegisternOTPService;

@Controller
@RequestMapping("/")
public class RegisternOTPController {

	public static String emailId;
	
	public String getEmailId() {
		return RegisternOTPController.emailId;
	}
	

	@Autowired
	private RegisternOTPService registernOTPService;

	@RequestMapping("/sendotpmail.vaccine")
	public String sendOTPMail(@RequestParam String emailId, Model model) {
		System.out.println("called sendRegistrationMail()");
		RegisternOTPController.emailId = emailId;
		if (this.registernOTPService.validateEmailId(emailId)) {
			int otp = this.registernOTPService.getOTP();
			boolean isMailSent = this.registernOTPService.sendOTPMail(emailId, otp);
			if (isMailSent) {
				boolean isSaved = this.registernOTPService.saveOTPToDB(emailId, otp);
				if (isSaved) {
					System.out.println("OTP Data saved");
				}
				model.addAttribute("OTP_Msg", "OTP Has Sent to Your EmailId !!");
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
		if (this.registernOTPService.validateVerifyOTP(otp)) {
			if (this.registernOTPService.verifyOTP(this.getEmailId(), otp)) {
				System.out.println("otp varified");
				model.addAttribute("OTP_Verified", "OTP Verified!!!");
				return "/WEB-INF/pages/Signup.jsp";
			} else {
				model.addAttribute("OTP_Invalid", "Wrong OTP Entered!!!");
				return "/WEB-INF/pages/Verifyotp.jsp";
			}

		} else {
			model.addAttribute("OTP_Invalid", "Invalid OTP Entered!!!");
			return "/WEB-INF/pages/Verifyotp.jsp";
		}

	}

	@RequestMapping("/resendotpmail.vaccine")
	public String resendOTPMail(Model model) {
		int otp = this.registernOTPService.getOTP();
		boolean otpMailReSent = this.registernOTPService.sendOTPMail(RegisternOTPController.emailId, otp);
		if (otpMailReSent) {
			if (this.registernOTPService.updateOTPinDB(RegisternOTPController.emailId, otp)) {
				model.addAttribute("OTP_Msg", "OTP Has Resent!!!");
				return "/WEB-INF/pages/Verifyotp.jsp";
			}
		} else {
			model.addAttribute("OTP_Msg", "Sorry!!! Something Went Wrong");
		}
		return "/WEB-INF/pages/Verifyotp.jsp";

	}

}
