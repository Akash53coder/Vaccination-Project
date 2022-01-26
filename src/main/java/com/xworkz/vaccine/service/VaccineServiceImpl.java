package com.xworkz.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.dao.VaccineDAO;
import com.xworkz.vaccine.entity.UserOTPEntity;
import com.xworkz.vaccine.util.OTPGenerator;

@Service
public class VaccineServiceImpl implements VaccineService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VaccineDAO vaccineDAO ;
	
	public VaccineServiceImpl() {
		super();
		System.out.println("bean created for" +this.getClass().getSimpleName());
	}
	@Override
	public boolean validateEmailId(String email) {
		System.out.println("called validateEmailId()");
		if(!email.isBlank() && !email.isEmpty() && email!=null) {
			return true;
		}
		return false;
	}

	@Override
	public int getOTP() {
		System.out.println("called getOTP()");
		return OTPGenerator.generateOTP();
	}

	@Override
	public boolean sendOTPMail(String email, int otp) {
		System.out.println("called sendOTP()");
		try {
			SimpleMailMessage mailMsg = new SimpleMailMessage();
			mailMsg.setTo(email);
			mailMsg.setSubject("OTP For Vaccine Registration");
			mailMsg.setText(otp+" Is Your OTP For Vaccination Registration");
			mailSender.send(mailMsg);
			return true;
		}catch(Exception exp) {
			System.out.println("An Exception Occured "+exp.getMessage());
			return false;
		}
		
	}
	@Override
	public boolean saveOTPToDB(String email, int otp) {
		System.out.println("called saveOTPinfo() in service");
		UserOTPEntity userOTPEntity = new UserOTPEntity(email,otp);
		Integer lastinsertId = this.vaccineDAO.saveOTP(userOTPEntity);
		if(lastinsertId!=0) {
			LASTINERTIDLIST.add(lastinsertId); 
			return true;
		}
		return false;
	}
	@Override
	public boolean validateVerifyOTP(Integer otp) {
		System.out.println("called validateVerifyOTP()");
		if(otp!=null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean verifyOTP(Integer otp) {
		System.out.println("called verifyOTP() in service");
		int len = VaccineService.LASTINERTIDLIST.size();
		int id = VaccineService.LASTINERTIDLIST.get(len - 1);
		Integer otpValue = this.vaccineDAO.isOTPPresent(id);
		if(otpValue!=null) {
			if(otpValue.compareTo(otp)==0) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String getEmailById(Integer id) {
		String emailIdFromDB = this.vaccineDAO.getEmailById(id);
		if(emailIdFromDB!=null) {
			return emailIdFromDB;
		}
		return null;
	}
	
	

}
