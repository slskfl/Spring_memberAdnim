package com.ezen.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ezen.member.dto.MemberVO;

public interface MemberService {
	
	//목록보기
	public List<MemberVO> listMembers() throws DataAccessException;
	
	//상세보기
	public MemberVO memberDetail(String memberid) throws DataAccessException;
	
	//등록하기
	public void addMember(MemberVO member) throws DataAccessException; 
	
	//수정하기
	public void updateMember(MemberVO member) throws DataAccessException; 
	
	//삭제하기
	public void deleteMember(String memberid) throws DataAccessException; 

}
