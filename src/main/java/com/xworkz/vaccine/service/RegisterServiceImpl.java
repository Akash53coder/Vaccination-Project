package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.util.OTPGenerator;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private JavaMailSender mailSender;
	
	public RegisterServiceImpl() {
		super();
		System.out.println("bean created for" +this.getClass().getSimpleName());
	}
	@Override
	public boolean validateEmailId(String email) {
		System.out.println("called validateEmailId()");
		if(!email.isBlank() && !email.isEmpty() && email!=null) {
			return true;
		}
		return false;
	}

	@Override
	public int getOTP() {
		System.out.println("called getOTP()");
		return OTPGenerator.generateOTP();
	}

	@Override
	public boolean sendOTPMail(String email, int otp) {
		System.out.println("called sendOTP()");
		try {
			SimpleMailMessage mailMsg = new SimpleMailMessage();
			mailMsg.setTo(email);
			mailMsg.setText(otp+" Is Your OTP For Vaccination Registration");
			mailSender.send(mailMsg);
			return true;
		}catch(Exception exp) {
			System.out.println("An Exception Occured "+exp.getMessage());
			return false;
		}
		
	}

}
