package com.min.biz.controller;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.min.biz.member.MemberVO;
import com.min.biz.member.impl.MemberDAO;

public class SigninController {

	public ModelAndView handleRequest(HttpServletRequest request) {
		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		ModelAndView mav = new ModelAndView();
		
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		mVO.setName(request.getParameter("name"));
		mVO.setRole(request.getParameter("role"));

		mDAO.insertMember(mVO);
		mav.setViewName("redirect:login.jsp");
		return mav;
	}

	
	
	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		MemberVO mVO = new MemberVO();
		MemberDAO mDAO = new MemberDAO();

		mVO.setMid(mid);
		mVO.setMpw(mpw);
		mVO.setName(name);
		mVO.setRole(role);

		mDAO.insertMember(mVO);
		return "main.do";
	}
	*/
}
