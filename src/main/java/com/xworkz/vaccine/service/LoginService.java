package com.xworkz.vaccine.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	boolean validateLoginInfo(String userName, String password);

	boolean verifyUser(String userName, String password);
}
