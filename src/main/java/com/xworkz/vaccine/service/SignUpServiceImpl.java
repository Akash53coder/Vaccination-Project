package com.xworkz.vaccine.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.SignUpDAO;
import com.xworkz.vaccine.dto.UserSignUpDTO;
import com.xworkz.vaccine.entity.UserSignUpEntity;

@Service
public class SignUpServiceImpl implements SignUpService{

	@Autowired
	private SignUpDAO signUpDAO;
	
	@Override
	public boolean validateUserSignUp(UserSignUpDTO userSignUpDTO) {
		boolean flag = false;
		if (userSignUpDTO.getName() != null && !userSignUpDTO.getName().isBlank()
				&& !userSignUpDTO.getName().isBlank()) {
			flag = true;
		} else {
			flag = false;
			SignUpService.errorMap.put("Name_Invalid", "Name Invalid");
		}

		if (Long.valueOf(userSignUpDTO.getPhone()) != null) {
			flag = true;
		} else {
			flag = false;
			SignUpService.errorMap.put("{Phone_Invalid", "Name Invalid");
		}

		if (userSignUpDTO.getGender() != null && !userSignUpDTO.getGender().isBlank()
				&& !userSignUpDTO.getGender().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			SignUpService.errorMap.put("Gender_Invalid", "Name Invalid");
		}

		if (userSignUpDTO.getPassword() != null && !userSignUpDTO.getPassword().isBlank()
				&& !userSignUpDTO.getPassword().isEmpty()) {
			flag = true;
			if (userSignUpDTO.getcPassword() != null && !userSignUpDTO.getcPassword().isBlank()
					&& !userSignUpDTO.getcPassword().isBlank()) {
				flag = true;
				if (userSignUpDTO.getcPassword().equals(userSignUpDTO.getPassword())) {
					flag = true;
				} else {
					flag = false;
					SignUpService.errorMap.put("Password_Mismatch", "Password Mismatch");
				}
			} else {
				flag = false;
				SignUpService.errorMap.put("Confirm_Password_Invalid", "Confirm Password Invalid");
			}
		} else {
			flag = false;
			SignUpService.errorMap.put("Password_Invalid", "Password Invalid");
		}

		if (userSignUpDTO.getDob() != null) {
			flag = true;
		} else {
			flag = false;
			SignUpService.errorMap.put("DOB_Invalid", "DOB Invalid");
		}
		return flag;
	}

	@Override
	public boolean saveSignUpInfo(UserSignUpDTO userSignUpDTO) {
		UserSignUpEntity entity = new UserSignUpEntity();
		BeanUtils.copyProperties(userSignUpDTO, entity);
		boolean dataSaved = this.signUpDAO.saveSignUpData(entity);
		if(dataSaved) {
			return true;
		}
		return false;
	}
}
