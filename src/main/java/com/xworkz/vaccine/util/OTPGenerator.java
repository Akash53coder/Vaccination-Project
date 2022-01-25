package com.xworkz.vaccine.util;

public class OTPGenerator {

	public static int generateOTP() {
		System.out.println("called generateOTP() in OTPGenerator");
		return (int)(Math.random()*(9999-0000+1)+0000);  
	}
}
