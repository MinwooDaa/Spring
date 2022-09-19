package com.min.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.biz.member.MemberVO;
import com.min.biz.member.impl.MemberDAO;

public class MypageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo = new MemberVO();
		MemberDAO mDAO= new MemberDAO();

		HttpSession session=request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");

		vo.setMid(mvo.getMid()); // 현재 접속한 사람 ID
		vo.setMpw(mvo.getMpw()); // 현재 접속한 사람 PW
		vo = mDAO.selectOneMember(vo); // 마이 페이지용 selectOne
		System.out.println(vo);

		if(vo!=null) {
			session.setAttribute("data", vo);
			return "mypage";
		}else {
			return "main.do";
		}
	}

}
