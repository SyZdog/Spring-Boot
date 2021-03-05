package com.cy.activity.service;

import java.util.List;

import com.cy.activity.pojo.Activity;

//业务层接口
public interface ActivityService {
	//基于id修改数据
	void updateActivity(Activity entity);
	//基于id查询数据
	Activity findById(Long id);
	//定义新增业务的方法
	void saveActivity(Activity entity);
	//定义查询业务的方法
	List<Activity> findActivity();
}
