package com.xworkz.vaccine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccine.dto.AddMemberDTO;
import com.xworkz.vaccine.service.AddMemberService;

@Controller
@RequestMapping("/")
public class AddMemberController {

	@Autowired
	private AddMemberService addMemberService;

	@RequestMapping("/addmember.vaccine")
	public String addMember(@ModelAttribute AddMemberDTO addMemberDTO, Model model) {
		System.out.println("this is addMemberdata" + addMemberDTO);
		boolean validated = this.addMemberService.validateAddMember(addMemberDTO);
		if (validated) {
			if (!this.addMemberService.checkAddMemberCount(LoginController.userName)) {
				if (this.addMemberService.saveAddedMember(addMemberDTO)) {
					model.addAttribute("Member_Added", "Member Added Successfully!");
					return "AddMember";
				} else {
					model.addAttribute("Member_Not_Added", "Member Not Added!");
					return "AddMember";
				}
			} else {
				model.addAttribute("Reached_Add_Member_Count", "Add Member Count Exceeded!");
				return "AddMember";
			}

		} else {
			Map<String, String> map = this.addMemberService.errorMap;
			model.addAttribute("Name_Invalid", map.get("Name_Invalid"));
			model.addAttribute("Gender_Invalid", map.get("Gender_Invalid"));
			model.addAttribute("YOB_Invalid", map.get("YOB_Invalid"));
			model.addAttribute("Photo_Id_Invalid", map.get("Photo_Id_Invalid"));
			model.addAttribute("Photo_Id_No_Invalid", map.get("Photo_Id_No_Invalid"));
			model.addAttribute("Dose_Invalid", map.get("Dose_Invalid"));
			model.addAttribute("Vaccine_Type_Invalid", map.get("Vaccine_Type_Invalid"));
			return "AddMember";
		}
	}
	
	@RequestMapping("/getAllAddedMember.vaccine")
	public String getAllAddedMember(Model model) {
		System.out.println("get all getAllAddedMember");
		List<Object> list = this.addMemberService.getAllMember(LoginController.userName);
		model.addAttribute("ListOfMembers", list);
		return "HomePage";
	}
	

}
