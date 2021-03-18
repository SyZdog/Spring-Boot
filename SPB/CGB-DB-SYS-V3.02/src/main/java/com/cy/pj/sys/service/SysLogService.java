package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

public interface SysLogService {
	int deleteObjects(int ...ids);
	/**
	 * 基于查询条件进行日志信息的分页查询
	 * @param username查询条件
	 * @param pageCurrent 当前页码值
	 * @return 当前页的记录+分页信息
	 * */
	
	PageObject<SysLog> findPageObject(String username,Long pageCurrent);
}
