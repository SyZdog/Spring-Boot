package com.cy.pj.common.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Aspect
@Component
public class SysExceptionAspect {
	@AfterThrowing(value="bean(sysUserServiceImpl)",throwing="ex")
	public void doLogError(Exception ex) {
		log.error("SysExceptionAspect.exception{}",ex.getMessage());
	}
}
