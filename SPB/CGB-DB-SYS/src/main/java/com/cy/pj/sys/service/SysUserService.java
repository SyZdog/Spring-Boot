package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;

public interface SysUserService {
	/**
	 * 更新用户自身信息以及用户对应的用户角色信息
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(SysUser entity, Integer[] roleIds);
	/**
	 * 查询并封装用户信息以及用户对应的角色信息
	 * @param id
	 * @return
	 */
	Map<String, Object> findObjectById(Long id);
	/**
	 * 保存用户自身信息以及用户对应的用户角色信息
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int saveObject(SysUser entity, Integer[] roleIds);
	/**
	 * 添加用于完成禁用或启用用户状态
	 * @param id
	 * @param valid
	 * @return
	 */
	int validById(Long id, Integer valid);
	/**
	 * 查询当前页要显示的用户信息以及分页信息
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysUserDeptVo> findPageObjects(String username, Long pageCurrent);
}
