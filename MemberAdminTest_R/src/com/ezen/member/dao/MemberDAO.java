package com.ezen.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ezen.member.dto.MemberVO;

public interface MemberDAO {

	
	//목록보기
	public List selectAllMembers()	throws DataAccessException;
	
	//상세보기
	public MemberVO selectMember(String memberid) throws DataAccessException;
	
	//등록하기
	public void insertMember(MemberVO member) throws DataAccessException; 
	
	//수정하기 
	public void updateMember(MemberVO member) throws DataAccessException; 
	
	//삭제하기
	public void deleteMember(String memberid) throws DataAccessException;
}
