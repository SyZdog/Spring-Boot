package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

//@Controller
//@ResponseBody
@RestController//@RestController=@Controller+@ResponseBody
@RequestMapping("/menu/")
public class SysMenuController {
	@Autowired
	private SysMenuService sysmenuService;
	
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysMenu entity){
		sysmenuService.updateObject(entity);
		return new JsonResult("update ok");
	}
	@RequestMapping("doFindZtreeMenuNodes")
	public JsonResult doFindZtreeMenuNodes() {
		return new JsonResult(sysmenuService.findZtreeMenuNodes());
		
	}
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
	    sysmenuService.deleteObject(id);
		return new JsonResult("delete ok");
		
	}
	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects() {
		return new JsonResult(sysmenuService.findObjects());
		
	}
}
