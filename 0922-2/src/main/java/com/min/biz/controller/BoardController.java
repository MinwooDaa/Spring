package com.min.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.min.biz.board.BoardVO;
import com.min.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("data") 		// data라는 이름의 데이터가 
public class BoardController {  // Model 객체에 세팅이 된다면, 그것을 session에 기억시키겠다.
	
	@ModelAttribute("scMap")
	public Map<String,String> searchCondition(){
		Map<String,String> scMap=new HashMap<String,String>();
		scMap.put("제목", "TITLE");
		scMap.put("작성자", "WRITER");
		return scMap; // model.addAttribute 가 자동으로 된것이다.
		
		// 20라인 == <option value="TITLE">제목</option>  
		// 21라인 == <option value="WRITER">작성자</option>
	}
	
	
	@RequestMapping("/main.do")
	public String main(BoardDAO bDAO,BoardVO bVO,HttpServletRequest request,Model model) {
		System.out.println("검색조건: "+bVO.getSearchCondition());	
		System.out.println("검색어: "+bVO.getSearchContent());
		System.out.println("메인 확인용"+bVO);
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		model.addAttribute("datas",datas);
		return "main.jsp";
	}
	
	
	@RequestMapping("/board.do")
	public String selectOneBoard(BoardVO bVO,BoardDAO bDAO,Model model,HttpSession session)  {
		bVO=bDAO.selectOneBoard(bVO);
		model.addAttribute("data", bVO);
	
		return "board.jsp";
	}
	@RequestMapping("/updateBoard.do")
	public String update(@ModelAttribute("data")BoardVO bVO, BoardDAO bDAO,HttpSession session) {
		System.out.println("update 로그 : "+bVO);
		bDAO.updateBoard(bVO);
		return "board.do";
		
	}
	
	@RequestMapping("/insertBoard.do")
	public String BoardInsert (BoardVO bVO,BoardDAO bDAO,HttpServletRequest request){
		
		bDAO.insertBoard(bVO);
		
		return "main.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String BoardDelete (BoardVO bVO,BoardDAO bDAO,HttpServletRequest request) {
		
		bDAO.deleteBoard(bVO);
		System.out.println("삭제되었나요 ?");
		return "main.do";
		
	}

}
