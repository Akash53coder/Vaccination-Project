package com.xworkz.vaccine.dao;


public interface LoginDAO {

	String isUserExist(String userName);
	int updateLoginAttempt(String userName,int currentAttempt);
	int getUpdatedAttempt(String userName);
	boolean resetPassword(String password,String emailId);
	
}
