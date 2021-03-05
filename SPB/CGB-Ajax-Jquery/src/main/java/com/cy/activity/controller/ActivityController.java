package com.cy.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.activity.pojo.Activity;
import com.cy.activity.service.ActivityService;
//访问路径：localhost/activity/doActivityUI
@Controller

@RequestMapping("/activity/")
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	//http://localhost/activity/doActivityUI
	//查询
	@RequestMapping("doActivityUI")
	public String doActivityUI(Model model) {
		return "activity";
	}
	
	//http://localhost/activity/doFindActivity
	@RequestMapping("doFindActivity")
	@ResponseBody //告诉SpringMVC将对象返回转换成json格式字符串
	public List<Activity> doFindActivity() {
		List<Activity> list = activityService.findActivity();
		return list;//显示格式为{"key1":"value","key2":"value2"}
	}
}
	
