package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "add_member")
public class AddMemberEntity {
	@Id
	@GeneratedValue(generator = "id") // present in jpa for generating unique and auto increment value
	@GenericGenerator(name = "id", strategy = "increment")
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String userName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "yob")
	private int yob;

	@Column(name = "id_proof")
	private String photo_id_proof;

	@Column(name = "id_proof_no")
	private int photo_id_no;

	@Column(name = "dose")
	private String dose;

	@Column(name = "vaccine_type")
	private String vaccine_type;

	@Column(name = "by_user")
	private String byUser;

	public AddMemberEntity() {
		super();
	}

	public AddMemberEntity(String userName, String gender, int yob, String photo_id_proof, int photo_id_no, String dose,
			String vaccine_type, String byUser) {
		this.userName = userName;
		this.gender = gender;
		this.yob = yob;
		this.photo_id_proof = photo_id_proof;
		this.photo_id_no = photo_id_no;
		this.dose = dose;
		this.vaccine_type = vaccine_type;
		this.byUser = byUser;
	}

	public String getByUser() {
		return byUser;
	}

	public void setByUser(String byUser) {
		this.byUser = byUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}

	public String getPhoto_id_proof() {
		return photo_id_proof;
	}

	public void setPhoto_id_proof(String photo_id_proof) {
		this.photo_id_proof = photo_id_proof;
	}

	public int getPhoto_id_no() {
		return photo_id_no;
	}

	public void setPhoto_id_no(int photo_id_no) {
		this.photo_id_no = photo_id_no;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getVaccine_type() {
		return vaccine_type;
	}

	public void setVaccine_type(String vaccine_type) {
		this.vaccine_type = vaccine_type;
	}

}
