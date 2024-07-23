package com.myweb.firstboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO에서 주로 사용하는 어노테이션
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MemberDto {
	
	private String userid;
	private String userpwd;
	private String username;
	private String birthdate;
	private String gender;
	private String usertel;
	private String useraddr;	
	private String useremail;
	private int permit;
	
}