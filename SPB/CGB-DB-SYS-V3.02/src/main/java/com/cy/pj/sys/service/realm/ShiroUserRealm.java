package com.cy.pj.sys.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;


public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private SysUserDao sysUserDao;
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	//认证
	/**
	 * 基于此方法的返回值告诉shiro框架我们采用什么加密算法
	 */
	@Override
	public CredentialsMatcher getCredentialsMatcher() {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		cMatcher.setHashIterations(1);
		return cMatcher;
	}
	/**
	 * 在此方法中负责认证信息的获取以及封装
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.获取登录用户信息（页面上用户输入的用户名）
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		String username = uToken.getUsername();
		//2.基于用户名查询数据库获取用户对象信息并进行判定
		//2.1获取用户对象
		SysUser user = sysUserDao.findUserByUserName(username);
		//2.2验证对象是否存在
		if (user == null) throw new UnknownAccountException();
		//2.3检查用户是否被禁用
		if(user.getValid() == 0) throw new LockedAccountException();
		//3.封装用户信息并返回
		ByteSource credenialSalt = ByteSource.Util.bytes(user.getSalt().getBytes());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
																user,//principal用户身份
																user.getPassword(),//hashedCredentials已经加密的密码
																credenialSalt,//credentialsSalt盐值
																this.getName());//getName()为realm的名字
		return info;//返回给认证管理器
	}
}
