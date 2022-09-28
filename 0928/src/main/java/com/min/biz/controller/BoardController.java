package com.min.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.min.biz.board.BoardService;
import com.min.biz.board.BoardVO;
import com.min.biz.member.MemberService;
import com.min.biz.member.MemberVO;

@Controller
@SessionAttributes("data") 		// data라는 이름의 데이터가 
public class BoardController {  // Model 객체에 세팅이 된다면, 그것을 session에 기억시키겠다.
	
	@Autowired
	private BoardService boardService; // 비즈니스 컴포넌트. 의존성 주입
	@Autowired
	private MemberService memberService;
	
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
	public String main(HttpSession session,MemberVO mVO,BoardVO bVO,Model model) {
		System.out.println("검색조건: "+bVO.getSearchCondition());	
		System.out.println("검색어: "+bVO.getSearchContent());
		System.out.println("메인 확인용"+bVO);
		
		// 검색조건이 NULL인지아닌지 체크하는 로직
		if(bVO.getSearchCondition()==null) {
			bVO.setSearchCondition("TITLE");
		}
		if(bVO.getSearchContent()==null) {
			bVO.setSearchContent("");
		}
		
		List<BoardVO> datas=boardService.selectAllBoard(bVO);
		model.addAttribute("datas",datas);
		
		return "main.jsp";
	}
	
	
	@RequestMapping("/board.do")
	public String selectOneBoard(BoardVO bVO,Model model)  {
		bVO=boardService.selectOneBoard(bVO);
		model.addAttribute("data", bVO);
	
		return "board.jsp";
	}
	@RequestMapping("/updateBoard.do")
	public String update(@ModelAttribute("data")BoardVO bVO) throws IllegalStateException, IOException {
		System.out.println("update.do 로그: "+bVO); // @SA,@MA 덕분에 writer 등의 값도 로그에 출력된다.
		
		MultipartFile uploadFile=bVO.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName=uploadFile.getOriginalFilename();
			bVO.setFileName(fileName);
			uploadFile.transferTo(new File("C:\\Users\\Minwoo\\git\\Spring\\test\\src\\main\\webapp\\images\\"+fileName));
		}
		
		boardService.updateBoard(bVO);
		return "redirect:main.do";
	}
	@RequestMapping("/delete.do")
	public String delete(BoardVO bVO) {
		boardService.deleteBoard(bVO);
		return "redirect:main.do";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insert(BoardVO bVO) throws IllegalStateException, IOException {
		System.out.println("insert.do 로그: "+bVO);
		
		/*
		MultipartFile uploadFile=bVO.getUploadFile();
		if(!uploadFile.isEmpty()) { // 업로드한 파일 존재여부 확인
			String fileName=uploadFile.getOriginalFilename(); // 업로드한 파일명
			uploadFile.transferTo(new File("D:\\0607KIM\\workspace2\\test\\src\\main\\webapp\\images\\"+fileName));
			// 업로드한 파일을 지정한 경로에 저장
		}
		*/
		
		bVO.setFileName("default.jpg");
		MultipartFile uploadFile=bVO.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName=uploadFile.getOriginalFilename();
			bVO.setFileName(fileName);
			uploadFile.transferTo(new File("C:\\Users\\Minwoo\\git\\Spring\\test\\src\\main\\webapp\\images\\"+fileName));
		}
		
		boardService.insertBoard(bVO);
		return "redirect:main.do";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard (BoardVO bVO) {
		
		boardService.deleteBoard(bVO);
		System.out.println("삭제되었나요 ?");
		return "main.do";
		
	}

}
