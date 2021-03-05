package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
//localhost/log/doFindPageObjects?pageCurrent=1
@Controller
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(int ...ids) {
		sysLogService.deleteObjects(ids);
		return new JsonResult("delete ok");
		
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Long pageCurrent) {
		PageObject<SysLog> pageObject = sysLogService.findPageObject(username, pageCurrent);
		return new JsonResult(pageObject);
	}
	
	/**创建一个全局异常类，专门用来处理异常*/
	//@ExceptionHandler描述异常处理方法的
	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		System.out.println("SysLogController");
		return new JsonResult(e);
	}
}
