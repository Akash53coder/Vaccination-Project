package com.xworkz.vaccine.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class UserSignUpDTO {

	private String name;
	private long phone;
	private String gender;
	private String password;
	private String cPassword;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	public UserSignUpDTO() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "UserSignUpDTO [name=" + name + ", phone=" + phone + ", gender=" + gender + ", password=" + password
				+ ", cPassword=" + cPassword + ", dob=" + dob + "]";
	}
	
}
