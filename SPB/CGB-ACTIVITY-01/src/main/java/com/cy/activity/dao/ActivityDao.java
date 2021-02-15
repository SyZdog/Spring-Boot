package com.cy.activity.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//数据层接口
import org.apache.ibatis.annotations.Select;

import com.cy.activity.pojo.Activity;
@Mapper
public interface ActivityDao {
	//查询
	@Select("select * from tb_activity")
	List<Activity> findActivity();
}
