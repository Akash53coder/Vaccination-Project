package com.xworkz.vaccine.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user_signup_info")
public class UserSignUpEntity {
	@Id
	@GeneratedValue(generator = "user_id") // present in jpa for generating unique and auto increment value
	@GenericGenerator(name = "user_id", strategy = "increment")
	@Column(name = "user_id")
	private int id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_phone")
	private long phone;
	@Column(name = "user_gender")
	private String gender;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	@Column(name = "user_emailId")
	private String emailId;
	
	public UserSignUpEntity() {
		super();
	}

	public UserSignUpEntity(String name, long phone, String gender, String password, Date dob, String emailId) {
		super();
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.dob = dob;
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "UserSignUpEntity [id=" + id + ", name=" + name + ", phone=" + phone + ", gender=" + gender
				+ ", password=" + password + ", dob=" + dob + ", emailId=" + emailId + "]";
	}
	
}
