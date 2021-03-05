package com.cy.pj.sys.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;

@ControllerAdvice
/**
 * @ControllerAdvice 注解描述的类为spring mvc中的一个全局异常处理类
 * 此类中可以定义多个全局异常处理方法，这些方法需要使用@ExceptionHandler注解
 * 进行修饰。
 * @ExceptionHandler （）中定义的异常类型就是此方法可以处理的异常类型
 * @author Administrator
 *
 */

public class GlobalExceptionHandler {
	//@ExceptionHandler注解用来描述异常处理方法
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
			e.printStackTrace();
			return new JsonResult(e);
	}

}
