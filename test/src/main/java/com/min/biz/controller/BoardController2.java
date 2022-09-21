package com.min.biz.controller;



import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;

public class BoardController2 {

	public void board(BoardVO bVO,BoardDAO bDAO) {
		bVO=bDAO.selectOneBoard(bVO);
	}
	
	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO bVO=new BoardVO();
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO bDAO=new BoardDAO();
		bVO=bDAO.selectOneBoard(bVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("data", bVO);
	
		return "board";
	}
	 */
	
}
