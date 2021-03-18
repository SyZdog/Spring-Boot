package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.SysLog;

@Mapper
public interface SysLogDao {
	/**
	 *基于id值执行删除操作
	 * @param ids
	 * @return
     *mybatis中的处理可变参数时，底层默认会将可变参数存储到一个array对象中
	 */
	int deleteObjects(int... ids);

	/*
	 * 基于查询条件(username)获取总记录数
	 * 
	 * @param username 查询条件
	 * @return 返回的是基于查询条件所查询出来的总记录数
	 * 
	 */
	
	int getRowCount(String username);

	/*
	 * 查询当前页要呈现的用户行为日志
	 * 
	 * @param username 查询条件
	 * 
	 * @param startIndex 当前页的起始位置
	 * 
	 * @param 页面大小（每页最多显示多少记录）
	 * 
	 * @return
	 */
	List<SysLog> findPageObject(String username, long startIndex, int pageSize);
}
