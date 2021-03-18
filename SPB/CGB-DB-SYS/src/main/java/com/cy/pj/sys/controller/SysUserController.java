package com.cy.pj.sys.controller;

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
