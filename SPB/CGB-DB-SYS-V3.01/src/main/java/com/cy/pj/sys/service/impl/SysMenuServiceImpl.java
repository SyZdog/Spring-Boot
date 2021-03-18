package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
@Service
public class SysMenuServiceImpl implements SysMenuService{

	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao SysRoleMenuDao;
	@Override
	public int updateObject(SysMenu entity) {
		//1.参数校验
		if (entity == null) throw new IllegalArgumentException("保存对象不能为空");
		//2.保存菜单对象
		int rows = sysMenuDao.insertObject(entity);
		if(rows == 0) throw new ServiceException("记录已经不存在");
		return rows;
	}
	@Override
	public int deleteObject(Integer id) {
		// TODO Auto-generated method stub
		//1.参数校验
		if(id==null || id <1)
			throw new IllegalArgumentException("id值无效");
		//2.基于菜单id统计菜单对应的子菜单个数并校验
		int rowCount = sysMenuDao.getChildCount(id);
		if(rowCount > 0)
			throw new ServiceException("请先删除子菜单");
		//3.删除菜单角色关系数据
		SysRoleMenuDao.deleteObjectByMenuId(id);
		//4.删除菜单自身信息
		int rows = sysMenuDao.deleteObject(id);
		if(rows == 0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}
	@Override
	public List<Map<String, Object>> findObjects() {
		return sysMenuDao.findObjects();
	}
	@Override
	public int insertObject(SysMenu entity) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Node> findZtreeMenuNodes() {
		// ....
		return sysMenuDao.findZtreeMenuNodes();
	}
	

}
