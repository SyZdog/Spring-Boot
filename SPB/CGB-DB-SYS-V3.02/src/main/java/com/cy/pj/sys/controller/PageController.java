package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.sys.entity.SysUser;
@RequestMapping("/")
@Controller
public class PageController {
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	@RequestMapping("doIndexUI")
	public String doIndexUI(Model model) {
		SysUser user = ShiroUtils.getUser();
		model.addAttribute("username", user.getUsername());
		return "starter";
		//访问路径：http://localhost/doInexUI
		//1.starer会返回给前端控制器（DispatcherServlet)
		//2.前端控制器（DispatcherServlet)会将页面名字交给视图解析器
		//3.视图解析器会在页面名字的基础上进行前缀和后缀的拼接，并进行解析
		//4.视图解析器会将解析的结果返回给DispatcherServlet
		//5.DispatcherServlet会将页面响应到客户端
	}
	//返回日志列表 
	//@RequestMapping("log/log_list")
	public String doLogUI() {
		return "sys/log_list";
	}
	
	//@RequestMapping("/menu/menu_list")
	public String doMenuUI(){
		return "sys/menu_list";
	}
	/**
	 * 	优化：
	 * REST风格的url映射：REST是一种软件加构编码风格，在这种风格下的url定义
	 * 可以使用{变量}的方式让url更加的简单通用。在方法参数中需要url中{变量}值时，
	 * 需要使用@PathVariable注解对方法参数进行描述，并且要求方法参数的名字要与
	 * {变量}表达式中的变量名相同
	 * @param moduleUI
	 * @return
	 */
	@RequestMapping("{model}/{modelUI}")
	public String doMoudleUI(@PathVariable String modelUI) {
		return "sys/"+modelUI;
	}
	//返回分页页面
		@RequestMapping("doPageUI")
		public String doPageUI() {
			return "common/page";
	}
}
