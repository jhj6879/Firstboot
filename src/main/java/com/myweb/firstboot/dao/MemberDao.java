package com.myweb.firstboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import com.myweb.firstboot.dto.MemberDto;

@Mapper
public interface MemberDao {
	
	@Select("select count(*) from member where userid=#{userid} and birthdate=#{birthdate} and usertel=#{usertel}")
	public boolean checkMember(MemberDto dto) throws DataAccessException;
	
//	@Select("select userid from member where birthdate=#{birthdate} and usertel=#{usertel}")
//	public String checkMemberId(MemberDto dto) throws DataAccessException;

	@Insert("INSERT INTO member VALUES (#{userid}, #{userpwd}, #{username}, #{birthdate}, #{gender}, #{usertel}, #{useraddr}, 0)")
	public boolean insertMember(MemberDto dto) throws DataAccessException;
	
	@Select("select count(*) from member where userid=#{userid}")
	public int checkId(@Param("userid") String userid) throws DataAccessException;

	// 로그인은 security로 해서 위에 수식과 조금 다름 (회원정보 요청할때도 사용함)  // 메서드랑 클래스는 하나에 하나의 기능만 
	@Select("select * from member where userid=#{userid}")
	public MemberDto getByUserId(@Param("userid") String userid) throws DataAccessException;
	
	
	@Update("update member set userpwd=#{userpwd} where userid=#{userid}")
	public void updateUserpwd(@Param("userid") String userid, @Param("userpwd") String userpwd) throws DataAccessException;
	
	@Update("update member set username=#{username} where userid=#{userid}")
	public void updateUsername(@Param("userid") String userid, @Param("username") String username) throws DataAccessException;
	
	@Update("update member set usertel=#{usertel} where userid=#{userid}")
	public void updatetel(@Param("userid") String userid, @Param("usertel") String usertel) throws DataAccessException;
	
	@Update("update member set useraddr=#{useraddr} where userid=#{userid}")
	public void updateaddr(@Param("userid") String userid, @Param("useraddr") String useraddr) throws DataAccessException;

	
	@Delete("delete from member where userid=#{userid}")
	public void deleteUser(@Param("userid") String userid) throws DataAccessException;

	@Select("select * from member")
	public List<MemberDto> selectMemeber() throws DataAccessException;

	@Update("update member set permit=#{permit} where userid=#{userid}")
	public void updatePermit(@Param("userid") String userid, @Param("permit") int permit) throws DataAccessException;

	@Select("select userid from member where username=#{username} and birthdate=#{birthdate} and usertel=#{usertel}")
	public String selectUserId(MemberDto dto) throws DataAccessException;
	
}
