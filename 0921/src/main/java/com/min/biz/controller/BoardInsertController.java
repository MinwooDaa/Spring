package com.min.biz.controller;

import javax.servlet.http.HttpServletRequest;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;


public class BoardInsertController {
	
	public void BoardInsert (HttpServletRequest request){
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		
		bVO.setTitle(request.getParameter("title"));
		bVO.setWriter(request.getParameter("writer"));
		bVO.setContent(request.getParameter("content"));
		
		bDAO.insertBoard(bVO);
		
	}
	
	
}
