package com.min.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;


public class AfterThrowingAdvice {
	@AfterThrowing(pointcut="PointcutCommon.apointcut")
	public void printLogAfterThrowing(JoinPoint jp,Exception exceptObj) {
		String methodName=jp.getSignature().getName();
	      Object[] args=jp.getArgs();
	      
	      System.out.println("수행중인 핵심메서드명: "+methodName);
	      System.out.println("사용하는 인자");
	      System.out.println("=====");
	      for(Object v:args) {
	         System.out.println(v);
	      }
	      System.out.println("=====");
	      
	      System.out.println("발생한 예외"+exceptObj.getMessage());
	      if(exceptObj instanceof IllegalArgumentException) {
	    	  System.out.println("올바르지 않은 인자값을 사용했습니다.");
	      }
	      else if(exceptObj instanceof NumberFormatException) {
	    	  System.out.println("숫자 형식이 아닌 값을 사용했습니다.");
	      }
	      else if(exceptObj instanceof Exception) {
	    	  System.out.println("예외가 발생했습니다.");
	      }
	      else {
	    	  System.out.println("확인되지 않은 에러가 발생했습니다.");
	      }
	      
	   }
	}

