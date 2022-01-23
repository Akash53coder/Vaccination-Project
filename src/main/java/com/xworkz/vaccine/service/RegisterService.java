package com.xworkz.vaccine.service;

public interface RegisterService {
	boolean validateEmailId(String email);
	int getOTP();
	boolean sendOTPMail(String email, int otp);
}
