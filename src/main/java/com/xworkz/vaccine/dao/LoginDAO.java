package com.xworkz.vaccine.dao;

import org.springframework.stereotype.Repository;


public interface LoginDAO {

	String isUserExist(String userName);
	
}
