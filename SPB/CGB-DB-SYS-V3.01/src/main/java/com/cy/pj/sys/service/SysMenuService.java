package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

public interface SysMenuService {
	int updateObject(SysMenu entity);
	int insertObject(SysMenu entity);
	List<Node> findZtreeMenuNodes();
	/**
	 * 基于菜单id删除菜单以及菜单对应的关系数据
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	List<Map<String, Object>> findObjects();
}
