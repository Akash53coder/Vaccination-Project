package com.xworkz.vaccine.service;

public interface VaccineService {
	boolean validateEmailId(String email);
	int getOTP();
	boolean sendOTPMail(String email, int otp);
	boolean saveOTPToDB(String email, int otp);
	boolean validateVerifyOTP(Integer otp);
	boolean verifyOTP(Integer otp);
}
