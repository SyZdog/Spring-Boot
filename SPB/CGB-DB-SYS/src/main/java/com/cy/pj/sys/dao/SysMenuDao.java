package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

@Mapper
public interface SysMenuDao {
	
	int updateObject(SysMenu entity);
	
	int insertObject(SysMenu entity);
	/**
	 * 查询菜单的id,name,parentId
	 * @return
	 */
	@Select("select id,name,parentId from sys_menus")
	List<Node> findZtreeMenuNodes();
	/**
	 * 基于菜单id统计子菜单的个数
	 * @param id 菜单id
	 * @return 子菜单的个数
	 */
	@Select("select count(*) from sys_menus where parentId=#{id}")
	int getChildCount(Integer id);
	/**
	 * 基于菜单id删除菜单自身信息
	 * @param id
	 * @return
	 */
	@Delete("delete from sys_menus where id=#{id}")
	int deleteObject(Integer id);
	/**
	 * 获取所有菜单信息，包含当前菜单对应的上级菜单的菜单名称
	 * @return
	 */
	List<Map<String,Object>> findObjects();
}
