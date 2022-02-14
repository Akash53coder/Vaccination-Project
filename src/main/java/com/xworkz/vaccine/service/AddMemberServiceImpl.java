package com.xworkz.vaccine.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xworkz.vaccine.controller.LoginController;
import com.xworkz.vaccine.dao.AddMemberDAO;
import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.entity.AddMemberEntity;

@Service
public class AddMemberServiceImpl implements AddMemberService {
	
	@Autowired
	private AddMemberDAO addMemberDAO;

	@Override
	public boolean validateAddMember(AddMemberDTO addMemberDTO) {
		System.out.println("called validateAddMember()");
		boolean flag = false;
		if (addMemberDTO.getUserName() != null 
				&& !addMemberDTO.getUserName().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			AddMemberService.errorMap.put("Name_Invalid", "Name Invalid");
			return flag;
		}
		if (addMemberDTO.getGender() != null 
				&& !addMemberDTO.getGender().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			AddMemberService.errorMap.put("Gender_Invalid", "Gender Invalid");
			return flag;
		}
		if (addMemberDTO.getYob() != 0) {
			flag = true;
		} else {
			flag = false;
			AddMemberService.errorMap.put("YOB_Invalid", "YOB Invalid");
			return flag;
		}
		if (addMemberDTO.getPhoto_id_proof() != null 
				&& !addMemberDTO.getPhoto_id_proof().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			AddMemberService.errorMap.put("Photo_Id_Invalid", "Photo Id Invalid");
			return flag;
		}
		if (addMemberDTO.getPhoto_id_no() != 0) {
			flag = true;
		} else {
			flag = false;
			AddMemberService.errorMap.put("Photo_Id_No_Invalid", "Photo Id No. Invalid");
			return flag;
		}
		if (addMemberDTO.getDose() != null  && !addMemberDTO.getDose().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			AddMemberService.errorMap.put("Dose_Invalid", "Dose Invalid");
			return flag;
		}
		if (addMemberDTO.getVaccine_type() != null 
				&& !addMemberDTO.getVaccine_type().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			AddMemberService.errorMap.put("Vaccine_Type_Invalid", "Photo Id Invalid");
			return flag;
		}
		return flag;
	}

	@Override
	public boolean saveAddedMember(AddMemberDTO addMemberDTO) {
		AddMemberEntity entity = new AddMemberEntity();
		entity.setByUser(LoginController.userName);
		BeanUtils.copyProperties(addMemberDTO, entity);
		boolean dataSaved = this.addMemberDAO.saveAddMember(entity);
		if(dataSaved) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkAddMemberCount(String userName) {
		int count = this.addMemberDAO.returnAddMemberCount(userName);
		if(count==2 || count>=2) {
			return true;
		}
		return false;
	}

	@Override
	public List<Object> getAllMember(String userName) {
		System.out.println("Invoked Service getAllMember");
		List<Object> container = null;
		List<AddMemberEntity> listEntity = this.addMemberDAO.getAllAddedMember(userName);
		if(listEntity!=null) {
			return container = new ArrayList<Object>(listEntity);
		}
		return null;
	}

}
