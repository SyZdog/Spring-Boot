package com.cy.activity.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.activity.dao.ActivityDao;
import com.cy.activity.pojo.Activity;

@Service
public class ActivityServiceImpl implements ActivityService {
	//slf4j门面模式
	private static final Logger log = LoggerFactory.getLogger(ActivityServiceImpl.class);
	@Autowired
	private ActivityDao activitydao;
	@Override
	public List<Activity> findActivity() {
		log.info("start{}",System.currentTimeMillis());
		List<Activity> list = activitydao.findActivity();
		log.info("end{}",System.currentTimeMillis());
		return list;
	}

}
