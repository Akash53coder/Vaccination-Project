package com.xworkz.vaccine.service;


public interface RegisternOTPService {
	boolean validateEmailId(String email);
	int getOTP();
	boolean sendOTPMail(String email, int otp);
	boolean saveOTPToDB(String email, int otp);
	boolean validateVerifyOTP(Integer otp);
	boolean verifyOTP(String email,Integer otp);
	boolean updateOTPinDB(String email, Integer otp);
	
}
