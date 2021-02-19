package com.cy.activity.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.activity.dao.ActivityDao;
import com.cy.activity.pojo.Activity;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityDao activitydao;
	//查询
	@Override
	public List<Activity> findActivity() {
		log.info("start{}",System.currentTimeMillis());
		List<Activity> list = activitydao.findActivity();
		log.info("end{}",System.currentTimeMillis());
		return list;
	}
	//新增
	@Override
	public void saveActivity(Activity entity) {
		// TODO Auto-generated method stub
		log.info("start{}",System.currentTimeMillis());
		//设置信息的创建时间为系统当前时间
		entity.setCreatedTime(LocalDateTime.now());
		activitydao.insertActivity(entity);
		log.info("end{}",System.currentTimeMillis());
	}
	//基于ID查询
	@Override
	public Activity findById(Long id) {
		// TODO Auto-generated method stub
		log.info("start{}",System.currentTimeMillis());
		Activity act = activitydao.findById(id);
		if (act == null) 
			throw new NoSuchElementException("对象可能已经不存在");
		log.info("end{}",System.currentTimeMillis());
		return act;
	}
	//修改
	@Override
	public void updateActivity(Activity entity) {
		// TODO Auto-generated method stub
		log.info("start{}",System.currentTimeMillis());
		int rows = activitydao.updateActivity(entity);
		log.info("end{}",System.currentTimeMillis());
	}

}
