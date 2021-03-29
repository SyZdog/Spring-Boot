package com.cy.pj.common.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.util.IPUtils;
import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

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
	 * @Pointcut 注解一般用于描述方法，在方法上定义切入点
	 * bean(sysUserServiceImpl) 为一个切入点表达式
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
			//将用户的正常行为信息写入到数据库中
			saveLog(jp, t2-t1);
			return result;
		} catch (Throwable e) {
			//
			log.error("erro is {}",e.getMessage());
			throw e;
		}
	}
	@Autowired
	private SysLogService sysLogService;
	private void saveLog(ProceedingJoinPoint jp, long time) throws Exception{
		//1.获取用户行为数据
		//1.1获取调用目标方法时的传递的参数
		String params = Arrays.toString(jp.getArgs());
		//1.2获取目标方法所在的类型
		Class<? extends Object> targetCls = jp.getTarget().getClass();//获取到的是类型
		String targetClsName = targetCls.getName();//获取的是类型的名
		//1.3获取目标方法的方法信息
		MethodSignature ms = (MethodSignature) jp.getSignature();
		//获取操作名operation
		Method targetMethod=
    			targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
    	RequiredLog requiredLog = 
    			targetMethod.getAnnotation(RequiredLog.class);
    	String operation="operation";//默认字符串
    	//if(requiredLog != null) operation=requiredLog.operation();//字符串替换
		ms.getName();//获取的是目标方法的方法名
		String targetClsMethodName = targetClsName + "." + ms.getName();
		//2.封装用户行为数据
		SysLog entity = new SysLog();
		entity.setIp(IPUtils.getIpAddr());
		entity.setUsername(ShiroUtils.getUserName());
		entity.setOperation(operation);
		entity.setMethod(targetClsMethodName);
		entity.setParams(params);
		entity.setTime(time);
		entity.setCreatedTime(new Date());
		//3.保存用户行为日志
		sysLogService.saveObject(entity);
	}
}
