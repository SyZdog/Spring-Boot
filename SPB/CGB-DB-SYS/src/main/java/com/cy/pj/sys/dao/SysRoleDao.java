package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.SysRole;

@Mapper
public interface SysRoleDao {
	/**
	 * 保存角色自身信息
	 * @param entity
	 * @return
	 */
	int insertObject(SysRole entity);
	/**
	 * 基于角色id去删除角色自身信息
	 * @param id
	 * @return
	 */
	@Delete("delete from sys_roles where id=#{id}")
	int deleteObject(Integer id);
	/**
	 * 统计记录的总数
	 * @param name
	 * @return
	 */
	int getRowCount(String name);
	/**
	 * 查询当前页的记录
	 * @param name
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysRole> findPageObjects(String name, Long startIndex, int pageSize);

}
