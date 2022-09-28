package com.min.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.min.biz.member.MemberService;
import com.min.biz.member.MemberVO;
import com.min.biz.member.impl.MemberDAO;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET) // 화면보여줘
	public String index() {
		return "login.jsp";
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String selectOneMember(MemberVO mVO,ModelAndView mav,HttpSession session)  {
		System.out.println("5");
		System.out.println("로그인 로그 "+mVO);
		mVO=memberService.selectOneMember(mVO);

		if(mVO==null) {
			System.out.println("로그인 실패!");
			return "login.jsp";
			
		}
		else {
			session.setAttribute("member", mVO);
			System.out.println("로그인되었습니다!");
			return "main.do";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request)  {
		HttpSession session=request.getSession();
		session.invalidate(); // 세션 비우기
		System.out.println("이용해주셔서 감사합니다.");
		return "redirect:login.do";
	}
	
	
	@RequestMapping("/signin.do")
	public String insertMember(MemberVO mVO,HttpServletRequest request)  {
		System.out.println("가입승인중...");
		memberService.insertMember(mVO);
		System.out.println("가입완료");
		return "redirect:login.jsp";
		
	}
	
	
	@RequestMapping("/mypage.do")
	public String mypage(MemberVO vo,ModelAndView mav,HttpServletRequest request)  {
		HttpSession session=request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		
		System.out.println("마이페이지로그  "+mvo);
		vo = mvo;
		vo = memberService.selectOneMember(vo); // 마이 페이지용 selectOne
		System.out.println("마이페이지 로그 2 "+vo);
		
		if(vo!=null) {
			System.out.println("마이페이지입니다.");
			session.setAttribute("member", vo);
			return "mypage.jsp";
		}else {
			System.out.println("잘못된 접근입니다!");
			return "main.do";
		}
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo,HttpServletRequest request) {
		System.out.println(vo);
		memberService.deleteMember(vo);
		HttpSession session=request.getSession();
		session.invalidate(); // 세션 비우기
		System.out.println("잘가요 내 소중한 XX,,,");
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/updateMember.do")
	public String updateMember(@ModelAttribute("mamber")MemberVO vo,ModelAndView mav,HttpServletRequest request) {
		
		memberService.updateMember(vo);
		System.out.println("정보가 수정되었습니다. 다시 로그인해주세요!");
		return "redirect:login.jsp";
		
	}
	
	
	
}
