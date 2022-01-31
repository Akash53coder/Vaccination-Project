package com.xworkz.vaccine.service;

import java.util.HashMap;
import java.util.Map;

import com.xworkz.vaccine.dto.UserSignUpDTO;

public interface SignUpService {
	
	Map<String,String> errorMap = new HashMap<String,String>();
	boolean validateUserSignUp(UserSignUpDTO userSignUpDTO);
	boolean saveSignUpInfo(UserSignUpDTO userSignUpDTO);
	boolean sendSignupMail(String emailId);
	String getPassword(String emailId);
}
