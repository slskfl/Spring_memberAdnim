package com.ezen.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;



public interface MemberController {
	
	//목록보기 >> listMember.jsp
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//상세보기 >> memberDetail.jsp
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//등록화면 and 수정화면 memberForm.jsp
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//등록하기
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//수정하기
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//삭제하기
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
