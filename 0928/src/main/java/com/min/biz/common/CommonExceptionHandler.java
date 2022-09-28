package com.min.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.min.biz") // CommonExceptionHandler를 객체화 해주는 @ // C가 핵심관심사고 아래의 메서드들이 횡단관심처럼 적용된다.
public class CommonExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView aException(Exception e) { // 널포인트 익셉션 a
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("error/error.jsp");
		return mav;
		// 어떤 예외가 발생했는지 같이 보내고 싶어서 리턴을 mav로
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView bException(Exception e) { // 수학적인 익셉션 b
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("error/error.jsp");
		return mav;
		// 어떤 예외가 발생했는지 같이 보내고 싶어서 리턴을 mav로
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView cException(Exception e) { // 미확인 익셉션 b
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("error/error.jsp"); 	
		return mav;
		// 어떤 예외가 발생했는지 같이 보내고 싶어서 리턴을 mav로
	}
}
