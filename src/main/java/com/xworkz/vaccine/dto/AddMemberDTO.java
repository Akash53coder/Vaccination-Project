package com.xworkz.vaccine.dto;

public class AddMemberDTO {

	private String userName;
	private String gender;
	private int yob;
	private String photo_id_proof;
	private int photo_id_no;
	private String dose;
	private String vaccine_type;

	public AddMemberDTO() {
		super();
	}

	public AddMemberDTO(String userName, String gender, int yob, String photo_id_proof, int photo_id_no, String dose,
			String vaccine_type) {
		super();
		this.userName = userName;
		this.gender = gender;
		this.yob = yob;
		this.photo_id_proof = photo_id_proof;
		this.photo_id_no = photo_id_no;
		this.dose = dose;
		this.vaccine_type = vaccine_type;
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

	@Override
	public String toString() {
		return "AddMemberDTO [userName=" + userName + ", gender=" + gender + ", yob=" + yob + ", photo_id_proof="
				+ photo_id_proof + ", photo_id_no=" + photo_id_no + ", dose=" + dose + ", vaccine_type=" + vaccine_type
				+ "]";
	}
	

}
