package com.myweb.firstboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import com.myweb.firstboot.dto.BoardDto;
import com.myweb.firstboot.dto.PostDto;
import com.myweb.firstboot.dto.ReplyDto;

@Mapper
public interface BoardDao {
	@Select("select * from post order by post_no desc")
	public List<PostDto> selectPostListAll() throws DataAccessException;
	
	//오버로딩
	@Select("select * from post where board_no=#{board_no} order by post_no desc")
	public List<PostDto> selectPostListByBoardNo(@Param("board_no") int board_no) throws DataAccessException;
	
	
	@Insert("insert into post(board_no, title, content, userid, create_date, update_date, hit_cnt)"
			+"values (#{board_no}, #{title}, #{content}, #{userid}, now(), now(), 0)")
	@Options(useGeneratedKeys=true, keyProperty="post_no") //자동으로 번호를 생성해주는 데이터를 사용할 때 사용하는 Options
	public void insertPost(PostDto dto) throws DataAccessException;
	
	@Select("select*from post where post_no=#{post_no}")
	public PostDto selectPostByPostNo(@Param("post_no") int post_no) throws DataAccessException;
	
	@Update("update post set hit_cnt = hit_cnt + 1 where post_no=#{post_no}")
	public void updateHitCnt(@Param("post_no") int post_no) throws DataAccessException;
	
	@Delete("delete from post where post_no=#{post_no}")
	public void deletePost(@Param ("post_no") int post_no) throws DataAccessException;
	
	@Update("update post set title=#{title}, content=#{content}, update_date=now() where post_no=#{post_no}")
	public void updatePost(PostDto dto) throws DataAccessException;
	
	@Insert("insert into reply values (null, #{post_no}, #{userid}, #{comment}, now(), now())")
	public void insertReply(ReplyDto reply) throws DataAccessException;
	
	@Select("select * from reply where post_no=#{post_no} order by reply_no desc")
	public List<ReplyDto> selectReply(@Param ("post_no") int post_no) throws DataAccessException;
	
	
	
	
	@Select("select * from board") //게시글 전체
	public List<BoardDto> selectBoardList() throws DataAccessException;
	@Select("select * from board where board_no=#{board_no}") //게시글 번호
	public BoardDto selectBoard(@Param("board_no") int board_no) throws DataAccessException;
	
	@Select("select board_no from post where post_no=#{post_no}")
	public int selectBoardNoByPostNo(@Param ("post_no") int post_no) throws DataAccessException; 
	
	
	//관리자 게시판 수정
	@Update("update board set board_name=#{board_name}, descript=#{descript} where board_no=#{board_no}")
	public void updateBoard(BoardDto dto) throws DataAccessException;
	//관리자 게시판 삭제
	@Delete("delete from board where board_no=#{board_no}")
	public void deleteBoard(@Param("board_no") int board_no) throws DataAccessException;
	//관리자 게시판 추가
	@Insert("insert into board values(null, #{board_name}, #{descript})")
	public void insertBoard(BoardDto dto) throws DataAccessException;
	
}
