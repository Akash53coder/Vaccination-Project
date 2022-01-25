package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.UserOTPEntity;

public interface VaccineDAO {

	boolean saveOTP(UserOTPEntity userOTPEntity);
	Integer isOTPPresent(Integer otp);
}
