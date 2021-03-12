package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;

public interface SysRoleService {
	/**
	 * 保存角色以及角色所对应的角色菜单信息
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int saveObject(SysRole entity, Integer[] menuIds);
	/**
	 * 删除角色自身信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	PageObject<SysRole> findPageObjects(String name, Long pageCurrent);
}
