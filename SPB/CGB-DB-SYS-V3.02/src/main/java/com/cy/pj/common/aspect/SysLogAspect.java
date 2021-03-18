package com.cy.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 *  @Aspect 注解描述的类型为一个切面类型(Aop中的横切面类型)，这样的切面类型
 * 中通常会定义两部分内容：
 * 1)切入点：切入扩展功能的点(例如业务对象中的一个或多个方法)
 * 2)通知：在切点对应的方法执行时，要织入的扩展功能
 * @author zdzsmacbookpro
 *
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {
	/**
	 * 
	 */
	@Pointcut("bean(sysUserServiceImpl)")
	public void doPointCut() {}
	@Around("doPointCut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		//1.记录方法执行时开始的时间
		long t1 = System.currentTimeMillis();
		try {
			//2.调用目标方法
			Object result = jp.proceed();//调用本切面中其他通知或下一个切面的通知或目标方法
			//3.记录方法执行的结束时间以及总时长
			long t2 = System.currentTimeMillis(); 
			log.info("method execute time{}",(t2-t1));
			return result;
		} catch (Throwable e) {
			//
			log.error("erro is {}",e.getMessage());
			throw e;
		}
		
	}
}
