package com.cy.pj.sys.controller;


import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;

@RestController
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("doLogin")
	public JsonResult doLogin(String username, String password) {
		//1.获取subject对象
		Subject subject = SecurityUtils.getSubject();
		//2.提交用户请求
		//2.1对用户信息进行封装
		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(username);
		token.setPassword(password.toCharArray());
		//2.2对用户信息身份认证
		subject.login(token);//提交给securityManager
		/**
		 * 分析：
		 * 1）token会传给shiro的SecurityManager
		 * 2）SecurityManager将token传递给认证管理器
		 * 3）认证管理器会将token传递给realm
		 */
		return new JsonResult("login ok");
	}
	
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysUser entity, Integer[] roleIds) {
		sysUserService.updateObject(entity, roleIds);
		return new JsonResult("update ok");
		
	}
	
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Long id) {
		return new JsonResult(sysUserService.findObjectById(id));
	}
	
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysUser entity, Integer[] roleIds) {
		sysUserService.saveObject(entity, roleIds);
		return new JsonResult("save ok");
		
	}
	
	@RequestMapping("doValidById")
	public JsonResult doValidById(Long id, Integer valid) {
		sysUserService.validById(id, valid);
		return new JsonResult("update ok");
		
	}
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String username, Long pageCurrent) {
		return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
	}
}
