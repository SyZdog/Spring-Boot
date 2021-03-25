package com.cy.pj.common.aspect;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.cy.pj.common.annotation.ClearCache;
import com.cy.pj.common.annotation.RequiredCache;

@Aspect
@Component
public class SysCacheAspect {
	private Map<Object, Object> cache = new ConcurrentHashMap<>();
	
	@Pointcut("@annotation(com.cy.pj.common.annotation.RequiredCache)")
	public void doCache() {}
	@Pointcut("@annotation(com.cy.pj.common.annotation.ClearCache)")
	public void doClear() {}
	
	@AfterReturning("doClear()")
	public void doAfterReturing(JoinPoint jp) throws Throwable{
		//获取目标方法对象
		Class<? extends Object> targetCls = jp.getTarget().getClass();
		//Method targetMethod = ms.getMethod();
		MethodSignature ms = (MethodSignature) jp.getSignature();
		//获取class里声明的方法和参数，name-string,parametertypes-[]
		Method targetMethod = targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
		System.out.println("targetMethod"+targetMethod);
		//获取目标方法上的注解
		ClearCache clearCache = targetMethod.getAnnotation(ClearCache.class);
		Object key = clearCache.key();
		System.out.println("doAfterReturing.Cache.key="+key);
		//cache.clear();
		cache.remove(key);
	}
	
	@Around("doCache()")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable{
		//获取目标方法对象
		Class<? extends Object> targetCls = jp.getTarget().getClass();
		MethodSignature ms = (MethodSignature) jp.getSignature();
		//Method targetMethod = ms.getMethod();
		Method targetMethod = targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
		System.out.println("targetMethod"+targetMethod);
		//获取目标方法上的注解
		RequiredCache requiredCache = targetMethod.getAnnotation(RequiredCache.class);
		Object key = requiredCache.key();
		System.out.println("Cache.key="+key);
		//==================================================
		System.out.println("Get Data from Cache");
		Object result = cache.get(key);
		if(result != null) return result;
		result = jp.proceed();
		System.out.println("Put Data from Cache");
		cache.put(key,result);
		return result;
	}
}
