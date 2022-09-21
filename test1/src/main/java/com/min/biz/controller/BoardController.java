package com.min.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("/main.do")
	public ModelAndView main(BoardDAO bDAO,BoardVO bVO,HttpServletRequest request,ModelAndView mav) {
		
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		mav.addObject("datas", datas);
		mav.setViewName("main.jsp");
		return mav;
	}
	
	
	@RequestMapping("/board.do")
	public String selectOneBoard(BoardVO bVO,BoardDAO bDAO,HttpServletRequest request)  {
		bVO=bDAO.selectOneBoard(bVO);
		
		request.setAttribute("data", bVO);
		return "board.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public ModelAndView BoardInsert (BoardVO bVO,BoardDAO bDAO,ModelAndView mav,HttpServletRequest request){
		
		bDAO.insertBoard(bVO);
		mav.setViewName("main.do");
		return mav;
	}
	
}
