package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private BCryptPasswordEncoder encrypt;
	
	@Autowired
	private LoginDAO loginDAO;
	@Override
	public boolean validateLoginInfo(String userName, String password) {
		boolean flag= false;
		if(!userName.isBlank() && !userName.isEmpty() && userName!=null) {
			flag = true;
		}else {
			flag=false;
			return flag;
		}
		if(!password.isBlank() && !password.isEmpty() && password!=null) {
			flag = true;
		}else {
			flag=false;
			return flag;
		}
		return flag;
	}
	
	@Override
	public  boolean verifyUser(String userName, String password) {
		String dbPassword = this.loginDAO.isUserExist(userName);
		if(this.encrypt.matches(password, dbPassword)) {
			return true;
		}
		return false;
	}

}
