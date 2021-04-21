package com.ezen.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ezen.member.dao.MemberDAO;
import com.ezen.member.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	/*MemberDAO주입 하였음*/
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
		System.out.println("listMembers.jsp :MemberServiceImpl->listMembers()");
		List membersList = null;
		membersList = memberDAO.selectAllMembers();
		return membersList;

	}

	@Override
	public MemberVO memberDetail(String memberid) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("memberDetail.jsp :MemberServiceImpl->memberDetail()");
		MemberVO member=null;
		member=memberDAO.selectMember(memberid);
		return member;
	}

	@Override
	public void addMember(MemberVO member) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("memberForm.jsp :MemberServiceImpl->addMember()");
		memberDAO.insertMember(member);
		
	}

	@Override
	public void updateMember(MemberVO member) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("memberDetail.jsp :MemberServiceImpl->updateMember()");
		memberDAO.updateMember(member);
	}

	@Override
	public void deleteMember(String memberid) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("memberDetail.jsp :MemberServiceImpl->deleteMember()");
		memberDAO.deleteMember(memberid);
	}

}
