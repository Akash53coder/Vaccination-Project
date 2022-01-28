package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.UserOTPEntity;

public interface RegisternOTPDAO {

	boolean saveOTP(UserOTPEntity userOTPEntity);
	Integer isOTPPresent(String email);
	boolean updateOTPDetails(UserOTPEntity userOTPEntity);
}
