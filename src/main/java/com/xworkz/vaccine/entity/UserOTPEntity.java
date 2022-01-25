package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_otp")
public class UserOTPEntity {

	@Id
	@Column(name = "otp_id")
	@GeneratedValue(generator = "otp_id") // present in jpa for generating unique and auto increment value
	@GenericGenerator(name = "otp_id", strategy = "increment")
	private int id;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "otp")
	private int otp;

	public UserOTPEntity() {
		super();
	}

	public UserOTPEntity(String emailId, int otp) {
		super();
		this.emailId = emailId;
		this.otp = otp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "UserOTPEntity [id=" + id + ", emailId=" + emailId + ", otp=" + otp + "]";
	}

}
