package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao {
	/**
	 * 修改用户密码、盐值
	 * @param password
	 * @param salt
	 * @param id
	 * @return
	 */
	@Update("update sys_users set password=#{password}, salt=#{salt}, modifiedTime=now() where id=#{id}")
	int updatePassword(@Param("password")String password, @Param("salt")String salt, @Param("id")Integer id);
	
	/**
	 * 通过用户名查找用户
	 * @param username
	 * @return
	 */
	@Select("select * from sys_users where username=#{username}")
	SysUser findUserByUserName(String username);
	
	/**
	 * 更新用户自身信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);
	
	/**
	 * 基于用户id查找用户以及用户对应的部门信息
	 * @param id
	 * @return
	 */
	SysUserDeptVo findObjectById(Integer id);
	
	/**
	 * 保存用户自身信息
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);
	
	/**
	 * 修改用户状态信息
	 * @param id
	 * @param valid
	 * @param username
	 * @return
	 */
	@Update("update sys_users set valid=#{valid},modifiedUser=#{username},modifiedTime=now() where id=#{id}")
	int validById(Long id, Integer valid, String username);
	
	/**
	 * 基于查询条件查询总记录数
	 * @param username
	 * @return
	 */
	int getRowCount(String username);
	
	/**
	 * 基于查询条件去查询当前页记录
	 * @param username
	 * @param startIndex
	 * @param PageSize
	 * @return
	 */
	List<SysUserDeptVo> findPageObjects(String username, long startIndex, int pageSize);
}
