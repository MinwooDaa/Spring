package com.min.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.biz.member.MemberVO;
import com.min.biz.member.impl.MemberDAO;

public class SigninController implements Controller {

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
	
}
