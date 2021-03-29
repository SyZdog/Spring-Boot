package com.cy.pj.common.util;

import org.apache.shiro.SecurityUtils;

import com.cy.pj.sys.entity.SysUser;

public class ShiroUtils {
	//调用getUsername方法将SysUser类型对象转化为字符串
	public static String getUserName() {
		return getUser().getUsername();
	}
//通过SecurityUtils访问主体Subject，并通过getPrincipal()获取代理对象，转型为SysUser类型对象
	public static SysUser getUser() {
		// TODO Auto-generated method stub
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}
}
