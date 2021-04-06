package com.cy.activity.dao;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.activity.pojo.Activity;
//数据层接口
@Mapper
public interface ActivityDao {
	//修改
	@Update("update tb_activity set title=#{title},category=#{category},startTime=#{startTime},endTime=#{endTime},remark=#{remark} where id=#{id}")
	int updateActivity(Activity entity);
	
	//新增
	@Insert("insert into tb_activity (title,category,startTime,endTime,state,remark,createdUser,createdTime) values"
			+ "(#{title},#{category},#{startTime},#{endTime},#{state},#{remark},#{createdUser},#{createdTime})")
	int insertActivity(Activity entity);
	
	//基于ID查询
	@Select("select * from tb_activity where id=#{id}")
	Activity findById(Long id);
	
	//查询
	@Select("select * from tb_activity")
	List<Activity> findActivity();
}
