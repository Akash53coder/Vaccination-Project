package com.xworkz.vaccine.service;

import java.util.ArrayList;
import java.util.List;

public interface VaccineService {
	List<Integer> LASTINERTIDLIST = new ArrayList<>();
	boolean validateEmailId(String email);
	int getOTP();
	boolean sendOTPMail(String email, int otp);
	boolean saveOTPToDB(String email, int otp);
	boolean validateVerifyOTP(Integer otp);
	boolean verifyOTP(Integer otp);
	String getEmailById(Integer id);
}
