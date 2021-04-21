package com.ezen.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ezen.member.dao.MemberDAO;
import com.ezen.member.dto.MemberVO;
import com.ezen.member.service.MemberService;

public class MemberControllerImpl extends MultiActionController implements MemberController {

	private MemberService memberService;

	/* MemberService를 주입하고 있음*/
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("listMembers.jsp :MemberControllerImpl->listMembers()");
		ModelAndView mav = new ModelAndView();
		List<MemberVO> membersList = memberService.listMembers();
		mav.addObject("membersList", membersList); //jsp로 값 넘기기
		mav.setViewName("listMembers");
		return mav;
	}

	@Override
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("memberDetail.jsp :MemberControllerImpl->memberDetail()");
		ModelAndView mav=new ModelAndView();
		String memberid=request.getParameter("memberid"); //받은 아이디를 memberid 변수에 저장
		MemberVO member=memberService.memberDetail(memberid); //memberDetail의 memberid(매개변수)
		mav.addObject("member", member);
		mav.setViewName("memberDetail");
		return mav;
		
	}

	@Override
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("memberForm.jsp :MemberControllerImpl->memberForm()");
		
		String method = request.getParameter("method");
		System.out.println("method : " + method);

		ModelAndView mav = new ModelAndView();
		
		if(method==null) {
			List<MemberVO> membersList = memberService.listMembers();
			mav.addObject("membersList", membersList); //jsp로 값 넘기기
			mav.setViewName("listMembers");
		}else if(method.equals("addMember.do")) { 
			mav.addObject("method",method); 
		}else if(method.equals("updateMember.do")) {
			String memberid=request.getParameter("memberid");
			
			MemberVO member = memberService.memberDetail(memberid);
			
			mav.addObject("member", member);
			mav.addObject("method",method); 
		}
		mav.setViewName("memberForm");
		return mav;
	}

	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("memberForm.jsp :MemberControllerImpl->addMember()");
		
		String memberid=request.getParameter("memberid");
		String memberpw=request.getParameter("memberpw");
		String membername=request.getParameter("membername");
		String gender=request.getParameter("gender");
		String memberemail=request.getParameter("memberemail");
		
		MemberVO memberVO=new MemberVO();
		memberVO.setMemberId(memberid);
		memberVO.setMemberPw(memberpw);
		memberVO.setMemberName(membername);
		memberVO.setGender(gender);
		memberVO.setMemberEmail(memberemail);
		
		memberService.addMember(memberVO);
		
		ModelAndView mav = new ModelAndView();
		List<MemberVO> membersList = memberService.listMembers();
		mav.addObject("membersList", membersList); //jsp로 값 넘기기
		mav.setViewName("listMembers");
		
		return mav;
	}

	@Override
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("memberForm.jsp :MemberControllerImpl->updateMember()");
		
		
		String memberid=request.getParameter("memberid");
		String memberpw=request.getParameter("memberpw");
		String membername=request.getParameter("membername");
		String gender=request.getParameter("gender");
		String memberemail=request.getParameter("memberemail");
		
		MemberVO memberVO=new MemberVO();
		memberVO.setMemberId(memberid);
		memberVO.setMemberPw(memberpw);
		memberVO.setMemberName(membername);
		memberVO.setGender(gender);
		memberVO.setMemberEmail(memberemail);
		
		memberService.updateMember(memberVO);
		memberVO = memberService.memberDetail(memberid);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("member", memberVO); //jsp로 값 넘기기
		mav.setViewName("memberDetail");
		
		return mav;
	}

	@Override
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("memberDetail.jsp :MemberControllerImpl->deleteMember()");
		
		String memberid = request.getParameter("memberid"); 
		System.out.println("memberid : " + memberid);
		
		memberService.deleteMember(memberid);
		
		ModelAndView mav=new ModelAndView();
		List<MemberVO> membersList = memberService.listMembers();
		mav.addObject("membersList", membersList); //jsp로 값 넘기기
		mav.setViewName("listMembers");
		return mav;
	}

}
