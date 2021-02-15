package com.cy.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.activity.pojo.Activity;
import com.cy.activity.service.ActivityService;
//访问路径：localhost/activity/doActivityUI
@Controller
@RequestMapping("/activity/")
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	@RequestMapping("doActivityUI")
	public String doActivityUI(Model model) {
		List<Activity> list = activityService.findActivity();
		model.addAttribute("list",list);
		return "activity";
		
	}
}
