package com.cy.pj.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;
import com.cy.pj.sys.vo.SysUserDeptVo;
@Service
public class SysUserServiceImpl implements SysUserService{
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Override
	public PageObject<SysUserDeptVo> findPageObjects(String username, Long pageCurrent) {
		//1.参数校验
		if(pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数并校验
		long rowCount = sysUserDao.getRowCount(username);
		if(rowCount == 0)
			throw new IllegalArgumentException("记录不存在");
		//3.查询当前页记录
		int pageSize = 3;
		long startIndex = (pageCurrent-1) * pageSize;
		List<SysUserDeptVo> records = sysUserDao.findPageObjects(username, startIndex, pageSize);
		//封装查询结果
		return new PageObject<>(records, rowCount, pageSize, pageCurrent);
	}
	@Override
	public int validById(Long id, Integer valid) {
		//1.参数校验
		if(id == null || id < 1)
			throw new IllegalArgumentException("id值无效");
		if(valid != 0 && valid != 1)
			throw new IllegalArgumentException("状态不正确");
		//2.更新状态
		int rows = sysUserDao.validById(id, valid, "admin");//admin假设为登陆用户
		if(rows == 0)
			throw new IllegalArgumentException("记录可能已经不存在");
		//3.返回结果
		return rows;
	}
	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		//1.参数校验
		if(entity == null )
			throw new IllegalArgumentException("保存对象不能为空");
		if(ObjectUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("用户名称不能为空");
		if(ObjectUtils.isEmpty(entity.getPassword()))
			throw new IllegalArgumentException("密码不能为空");
		if(roleIds == null || roleIds.length == 0)
			throw new ServiceException("必须要为用户指定角色");
		//2.保存用户信息
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5", entity.getPassword(), salt, 1);
		String hashedPassword = sh.toHex();
		//2.1保存用户自身信息
		entity.setSalt(salt);
		entity.setPassword(hashedPassword);
		//2.2保存用户角色数据
		int rows = sysUserDao.insertObject(entity);
		//3.保存用户关系数据
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		//4.返回结果
		return rows;
	}
	@Override
	public Map<String, Object> findObjectById(Long id) {
		//1.参数校验
		if(id == null || id < 1)
			throw new IllegalArgumentException("id值无效");
		//2.基于用户id执行查询操作
		SysUserDeptVo user = sysUserDao.findObjectById(id);
		if(user == null )
			throw new ServiceException("记录可能不存在");
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(id);
		//3.封装结果并返回
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}
	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		//1.参数校验
		if(entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(ObjectUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
		if(roleIds == null || roleIds.length == 0)
			throw new ServiceException("必须为用户指定角色");
		//2.更新用户信息
		int rows = sysUserDao.updateObject(entity);
		//3.保存用户角色关系数据
		//3.1基于用户id删除原有关系
		sysUserRoleDao.deleteObjectByRoleId(entity.getId());
		//3.2保存用户和角色的新的关系数据
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		//4.返回结果
		return rows;
	}

}
