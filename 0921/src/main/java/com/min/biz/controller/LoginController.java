package com.min.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.min.biz.member.MemberVO;
import com.min.biz.member.impl.MemberDAO;

/*
public class LoginController { 	
	
	public void selectOneMember(HttpServletRequest request)  {
		MemberVO mVO=new MemberVO();
		System.out.println("5");
		MemberDAO mDAO=new MemberDAO();

		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		System.out.println("로그인 로그 "+mVO);
		mVO=mDAO.selectOneMember(mVO);

		if(mVO==null) {
		
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mVO);
		}
	}
	
	
	
}
*/
	/*
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO mVO=new MemberVO();
		System.out.println("5");
		MemberDAO mDAO=new MemberDAO();

		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		System.out.println("로그인 로그 "+mVO);
		mVO=mDAO.selectOneMember(mVO);

		ModelAndView mav=new ModelAndView();
		if(mVO==null) {
			mav.setViewName("redirect:login.jsp");
			
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mVO);
			mav.setViewName("redirect:main.do");
		}
		return mav;
	}
} 
*/

/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		MemberVO mVO=new MemberVO();
		System.out.println("5");
		mVO.setMid(mid);
		mVO.setMpw(mpw);

		MemberDAO mDAO=new MemberDAO();
		mVO=mDAO.selectOneMember(mVO);

		if(mVO==null) {
			return "login"; // 
		}
		else {
			return "main.do";
		}
	}
 */

