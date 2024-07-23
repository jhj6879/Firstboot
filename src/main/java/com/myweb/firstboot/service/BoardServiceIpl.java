package com.myweb.firstboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myweb.firstboot.dao.BoardDao;
import com.myweb.firstboot.dto.BoardDto;
import com.myweb.firstboot.dto.PostDto;
import com.myweb.firstboot.dto.ReplyDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceIpl implements BoardService {
	
	private final BoardDao dao;
	
	public List<PostDto> getPostList(){
		return dao.selectPostListAll();
	}
	
	//오버로딩
	public List<PostDto> getPostListByBoard(int board_no){
		return dao.selectPostListByBoardNo(board_no);
	}
	
	public PostDto putPost(PostDto dto) {
		dao.insertPost(dto);
		return dao.selectPostByPostNo(dto.getPost_no());
	}
	
	
	public PostDto getPost(int post_no) {
		return dao.selectPostByPostNo(post_no);
	}

	//클릭할 때마다 조회수 업데이트
	public void cntHitCnt(int post_no) {
		dao.updateHitCnt(post_no);
	}
	
	public void delPost(int post_no) {
		dao.deletePost(post_no);
	}
	
	public PostDto editPost(PostDto dto) {
		dao.updatePost(dto);
		return dao.selectPostByPostNo(dto.getPost_no());
	}
	
	public void putReply(ReplyDto reply) {
		dao.insertReply(reply);
	}
	
	public List<ReplyDto> getReply(int post_no){
		return dao.selectReply(post_no);
	}
	
	public List<BoardDto> getBoardMenu(){
		return dao.selectBoardList();
	}
	
	public BoardDto getBoard(int board_no){
		return dao.selectBoard(board_no);
	}
	
	public int getBoardNo(int post_no) {
		return dao.selectBoardNoByPostNo(post_no);
	}
	 //관리자 게시판 수정
	public void editBoard(BoardDto dto) {
		dao.updateBoard(dto);
	}
	//관리자 게시판 삭제
	public void deleteBoard(int board_no) {
		dao.deleteBoard(board_no);
	}
	//관리자 게시판 추가
	public void addBoard(BoardDto dto) { 
		dao.insertBoard(dto);
	}
	
}

