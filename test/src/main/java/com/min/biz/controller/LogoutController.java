package com.min.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		session.invalidate(); // 세션 비우기
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}

//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session=request.getSession();
//		session.invalidate(); // 세션 비우기
//		
//		return "login";
//	}

}
