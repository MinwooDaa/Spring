package com.min.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;
 /*
public class MainController {

	public ModelAndView handleRequest(HttpServletRequest request) {
		BoardVO bVO=new BoardVO();
		
		BoardDAO bDAO=new BoardDAO();
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;
	}
}
*/
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		BoardVO bVO=new BoardVO();
//		
//		BoardDAO bDAO=new BoardDAO();
//		
//		return "main";
//	}
	
