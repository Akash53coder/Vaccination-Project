package com.xworkz.vaccine.dao;

import java.util.List;

import com.xworkz.vaccine.entity.AddMemberEntity;

public interface AddMemberDAO {
	
	boolean saveAddMember(AddMemberEntity addMemberEntity);
	int returnAddMemberCount(String userName);
	List<AddMemberEntity> getAllAddedMember(String userName);

}
