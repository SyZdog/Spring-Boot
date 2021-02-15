package com.cy.activity.service;

import java.util.List;

import com.cy.activity.pojo.Activity;

//业务层接口
public interface ActivityService {
	//定义查询业务的方法
	List<Activity> findActivity();
}
