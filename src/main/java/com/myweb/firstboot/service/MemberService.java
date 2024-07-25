package com.myweb.firstboot.service;

import java.util.List;

import com.myweb.firstboot.dto.MemberDto;

public interface MemberService {

	//boolean checkLogin(String userid, String userpwd);
	
	boolean putMember(MemberDto dto);

	boolean memberId(String userid);

	MemberDto getMemberInfo(String userid);

	MemberDto editMemberInfo(MemberDto dto);

	void unregistUser(String userid);

	List<MemberDto> getMemberList();

	void editUserPw(String userid, String userpwd);

	void deleteUser(String userid);

	void editUser(MemberDto dto);

	boolean checkMember(MemberDto dto);

	String getMemberByName(MemberDto dto);

}
