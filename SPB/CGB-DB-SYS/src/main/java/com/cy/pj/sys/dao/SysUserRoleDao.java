package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleDao {
	/**
	 * 基于角色id删除角色关系数据
	 * @param roleId
	 * @return
	 */
	@Delete("delete from sys_user_roles where role_id=#{roleId}")
	int deleteObjectByRoleId(Integer roleId);
}
