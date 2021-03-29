package com.cy.pj.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.common.vo.PageObject;
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
	@RequiredLog(operation = "用户查询")
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
	/**
	 * shiro框架通过@RequiresPermissions注解定义切入点，
	 * 在这里表示方法此方法需要进行授权，需要具备这个注解中的权限标识
	 * 1)需要系统基于登陆用户获取用户权限{"sys:user:update","sys:user:view",...}
	 * 2)当用户权限中包含@RequiresPermissions注解中定义的权限标识，
	 * 就表示用户拥有访问访问这个方法的权限
	 * 3)拥有权限时，则可以由shiro框架进行授权访问
	 */
	@RequiresPermissions("sys:user:update")
	@RequiredLog(operation = "禁用启用")
	@Override
	public int validById(Long id, Integer valid) {
		//1.参数校验
		if(id == null || id < 1)
			throw new IllegalArgumentException("id值无效");
		if(valid != 0 && valid != 1)
			throw new IllegalArgumentException("状态不正确");
		//2.更新状态
		int rows = sysUserDao.validById(id, valid, ShiroUtils.getUserName());//admin假设为登陆用户
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
		//2.1对密码进行加密（MD5盐值加密）
		//MD5：一种消息摘要算法
		//MD5特点：1.不可逆 2.相同内容加密结果相同
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5", entity.getPassword(), salt, 1);
		String hashedPassword = sh.toHex();//将加密结果转换为16进制
		//2.2保存用户自身信息
		entity.setSalt(salt);
		entity.setPassword(hashedPassword);
		//2.3保存用户角色数据
		int rows = sysUserDao.insertObject(entity);
		//3.保存用户关系数据
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		//4.返回结果
		return rows;
	}
	@Override
	public Map<String, Object> findObjectById(Integer id) {
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
	/**
	 * 
	 */
	@Override
	public int updatePassword(String password/*原密码*/, String newPassword, String cfgPassword/*确认密码*/) {
		//1.判定新密码与确认密码是否相同
		if(ObjectUtils.isEmpty(newPassword))
			throw new IllegalArgumentException("新密码不能为空");
		if (ObjectUtils.isEmpty(cfgPassword))
			throw new IllegalArgumentException("确认密码不能为空");
		if (!newPassword.equals(cfgPassword)) 
			throw new IllegalArgumentException("两次输入的密码不相等");
		//2.判定原密码是否正确
		if(ObjectUtils.isEmpty(password))
			throw new IllegalArgumentException("原密码不能为空");
		//2.1获取登录用户
		SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
		SimpleHash sh = new SimpleHash("MD5",password,user.getSalt(),1);
		if (!user.getPassword().equals(sh.toHex())) //生成16进制存储
			throw new IllegalArgumentException("原密码不正确");
		//3.对新密码进行加密
		String salt = UUID.randomUUID().toString();
		sh = new SimpleHash("MD5", newPassword, salt, 1);
		//4.将加密密码更新到数据库
		int rows = sysUserDao.updatePassword(sh.toHex(), salt, user.getId());
		if(rows == 0)
			throw new ServiceException("修改失败");
		return rows;
	}
}
