package com.min.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	
	
	@Pointcut("execution(* com.min.biz..*Impl.*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* com.min.biz..*Impl.select*(..))")
	public void bPointcut() {}
	
	
}
