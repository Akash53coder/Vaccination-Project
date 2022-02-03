package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.controller.RegisternOTPController;
import com.xworkz.vaccine.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private BCryptPasswordEncoder encrypt;

	public static int loginAttempt = 0;

	@Autowired
	private LoginDAO loginDAO;

	@Override
	public boolean validateLoginInfo(String userName, String password) {
		boolean flag = false;
		if (!userName.isBlank() && !userName.isEmpty() && userName != null) {
			flag = true;
		} else {
			flag = false;
			return flag;
		}
		if (!password.isBlank() && !password.isEmpty() && password != null) {
			flag = true;
		} else {
			flag = false;
			return flag;
		}
		return flag;
	}

	@Override
	public boolean verifyUser(String userName, String password) {
		String dbPassword = this.loginDAO.isUserExist(userName);
		if (dbPassword != null) {
			if (this.encrypt.matches(password, dbPassword)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean loginAttemptExceeded(String userName) {
		LoginServiceImpl.loginAttempt = this.loginDAO.updateLoginAttempt(userName, LoginServiceImpl.loginAttempt);
		if (LoginServiceImpl.loginAttempt == 3) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean checkloginAttemptExceeded(String userName) {
		int attempt = this.loginDAO.getUpdatedAttempt(userName);
		if (attempt == 3) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validateResetPasswords(String password, String confirmPassword) {
		boolean flag = false;
		if (password != null && confirmPassword != null) {
			if (!password.isBlank() && !password.isEmpty()) {
				if (!confirmPassword.isBlank() && !confirmPassword.isEmpty()) {
					if (password.equals(confirmPassword)) {
						return true;
					}
				}

			}
		}
		return false;
	}

	@Override
	public boolean resetPassword(String password,String emailId) {
		String encPwd = encrypt.encode(password);
		if(this.loginDAO.resetPassword(encPwd, emailId)) {
			return true;
		}
		return false;
	}

}
