//package com.min.biz.controller;
//
//import java.util.HashMap; 
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.min.biz.board.BoardVO;
//
//public class MainController {
//	
//	/*
//	@ModelAttribute("searchMap")
//	public Map<String,String> searchCondition(){
//		Map<String,String> scMap=new HashMap<String,String>();
//		scMap.put("제목", "TITLE");
//		scMap.put("작성자", "WRITER");
//		return scMap; // model.addAttribute 가 자동으로 된것이다.
//		
//		// 20라인 == <option value="TITLE">제목</option>  
//		// 21라인 == <option value="WRITER">작성자</option>
//	}
//	*/
//	
//	@RequestMapping("/main.do")
//	public String main(@RequestParam(value="searchCondition",defaultValue="TITLE",required=false)String searchCondition,@RequestParam(value="searchContent",defaultValue="",required=false)String searchContent,BoardVO bVO,Model model) {
//		System.out.println("검색조건: "+searchCondition);
//		System.out.println("검색어: "+searchContent);
//
//		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
//
//		model.addAttribute("datas", datas);
//		return "main.jsp";
//	}
//}
////	@Ovserride
////	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
////		BoardVO bVO=new BoardVO();
////		
////		BoardDAO bDAO=new BoardDAO();
////		
////		return "main";
////	}
//
