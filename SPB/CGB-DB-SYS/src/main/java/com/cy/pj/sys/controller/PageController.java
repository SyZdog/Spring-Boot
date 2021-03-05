package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/")
@Controller
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
		//访问路径：http://localhost/doInexUI
		//1.starer会返回给前端控制器（DispatcherServlet)
		//2.前端控制器（DispatcherServlet)会将页面名字交给视图解析器
		//3.视图解析器会在页面名字的基础上进行前缀和后缀的拼接，并进行解析
		//4.视图解析器会将解析的结果返回给DispatcherServlet
		//5.DispatcherServlet会将页面响应到客户端
	}
	//返回日志列表 
	@RequestMapping("log/log_list")
	public String doLogUI() {
		return "sys/log_list";
	}
	//返回分页页面
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	
}
