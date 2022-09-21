package com.min.biz.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping { // 싱글톤 패턴이 유지된다.
//	// input : 어떤 요청에 대해 == String
//	// output : 무슨 Controller 객체를 제공해야 하는지 == Controller
//	private Map<String,Controller> mappings; // 의존관계 -> DI => 생성자 주입
//	
//	public HandlerMapping() {
//		System.out.println("6");
//		mappings=new HashMap<String,Controller>();
//		mappings.put("/login.do",new LoginController()); 
//		mappings.put("/main.do", new MainController());
//		mappings.put("/mypage.do",new MypageController());
//		mappings.put("/signin.do",new SigninController());
//	}
//	
//	public Controller getController(String command) {
//		System.out.println("7");
//		return mappings.get(command);
//	}
}
