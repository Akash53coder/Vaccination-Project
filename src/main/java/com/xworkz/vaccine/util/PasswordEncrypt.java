package com.xworkz.vaccine.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypt {

	public static String encryptPassword(String password) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes());
			byte[] bytes = m.digest();
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return s.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("An exception occured "+e.getMessage());
		}
		return null;

	}
}
