package com.myweb.firstboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.firstboot.dao.MemberDao;
import com.myweb.firstboot.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberDao memberDao;
	private final PasswordEncoder passwordEncoder;
	
//	@Autowired
//	public MemberServiceImpl(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
//	public boolean checkLogin(String userid, String userpwd) {
//		boolean result = false;
//		if (memberDao.checkMember(userid, userpwd) > 0) result = true;
//		return result;
//	}

	public boolean putMember(MemberDto dto) {
		return memberDao.insertMember(dto);
	}
	
	public boolean memberId(String userid) {
		boolean result = false;
		if(memberDao.checkId(userid) == 0) {
			result = true;
		}
		return result;
	}

	public MemberDto getMemberInfo(String userid) {
		MemberDto dto = new MemberDto();
		dto = memberDao.getByUserId(userid);
		return dto;
	}

	public MemberDto editMemberInfo(MemberDto dto) {
		MemberDto org = new MemberDto();
		org = memberDao.getByUserId(dto.getUserid());
		
		// 뷰로 입력받은 패스워드인지 확인하여 암호화
		if (dto.getUserpwd().length() <= 20)   // security에서 한번 암호화된 패스워드는 확인이 어려워서 이 작업함
			dto.setUserpwd(passwordEncoder.encode(dto.getUserpwd()));
		
		// 원본 패스워드와 뷰 패스워드가 다르면 패스워드 업데이트
		if (!dto.getUserpwd().equals(org.getUserpwd())) 
			memberDao.updateUserpwd(dto.getUserid(),dto.getUserpwd());
		
		// 원본 이름과 뷰 이름이 다르면 패스워드 업데이트
		if (!dto.getUsername().equals(org.getUsername())) 
			memberDao.updateUsername(dto.getUserid(),dto.getUsername());
		
		// 원본 전화번호와 뷰 전화번호가 다르면 전화번호가 업데이트
		if (!dto.getUsertel().equals(org.getUsertel())) 
			memberDao.updatetel(dto.getUserid(),dto.getUsertel());
		
		// 원본 주소와 뷰 주소가 다르면 전화번호가 업데이트
		if (!dto.getUseraddr().equals(org.getUseraddr())) 
			memberDao.updateaddr(dto.getUserid(),dto.getUseraddr());
		
		dto = memberDao.getByUserId(dto.getUserid());
		
		return dto;
	}

	public void unregistUser(String userid) {
		memberDao.deleteUser(userid);
	}

	public List<MemberDto> getMemberList() {
		List<MemberDto> list = new ArrayList<>();
		list = memberDao.selectMemeber();
		return list;
	}

	public void editUserPw(String userid, String userpwd) {
		// 암호화 시켜서 다시 패스워드에 저장
		userpwd = passwordEncoder.encode(userpwd);
		memberDao.updateUserpwd(userid, userpwd);
	}

	public void deleteUser(String userid) {
		memberDao.deleteUser(userid);
	}

	public void editUser(MemberDto dto) {
		MemberDto org = new MemberDto();
		org = memberDao.getByUserId(dto.getUserid());
		String chngPw = "";
		// 뷰로 입력받은 패스워드인지 확인하여 암호화
		if (dto.getUserpwd().length() <= 20)
			chngPw = passwordEncoder.encode(dto.getUserpwd());
		// 원본 패스워드와 뷰 패스워드가 다르면 패스워드 업데이트
		if (!dto.getUserpwd().equals(org.getUserpwd())) 
			memberDao.updateUserpwd(dto.getUserid(),chngPw);
		
		if (dto.getPermit() != org.getPermit()) 
			memberDao.updatePermit(dto.getUserid(),dto.getPermit());
		
	}

	public boolean checkMember(MemberDto dto) {
		return memberDao.checkMember(dto);
	}

	public String getMemberByName(MemberDto dto) {
		return memberDao.selectUserId(dto);
	}

//	public String checkMemberId(MemberDto dto) {
//		String userId = memberDao.checkMemberId(dto);
//		return userId;
//	}
	
	
}
