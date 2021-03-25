package com.cy.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SysTimeAspect {
	@Pointcut("bean(sysUserServiceImpl)")
	public void doTime() {}
	@Before("doTime()")
	public void doBefore() {
		System.out.println("@Before");
	}
	@After("doTime()")
	public void doAfter() {
		System.out.println("@After");
	}
	@AfterReturning("doTime()")
	public void doAfterReturning() {
		System.err.println("@AfterReturning");
	}
	@AfterThrowing("doTime()")
	public void doAfterThrowing() {
		System.out.println("@AfterThrowing");
	}
	@Around("doTime()")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("around.before");
		try {
			Object result = jp.proceed();
			System.out.println("around.after");
			return result;
		} catch (Throwable e) {
			System.out.println("around.exception");
			throw e;
		}
	}
}
