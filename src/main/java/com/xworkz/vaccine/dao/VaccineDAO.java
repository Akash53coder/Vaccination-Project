package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.UserOTPEntity;

public interface VaccineDAO {

	Integer saveOTP(UserOTPEntity userOTPEntity);
	Integer isOTPPresent(Integer id);
	String getEmailById(Integer id);
}
