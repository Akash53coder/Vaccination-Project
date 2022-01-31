package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.UserSignUpEntity;

public interface SignUpDAO {

	public boolean saveSignUpData(UserSignUpEntity userSignUpEntity);
	public String getPassword(String emailId);
}
