package com.cy.pj.common.config;


import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//此注解描述配置对象
public class SpringShiroConfig {
	/**
	 * 配置shiro中的核心对象：安全管理器
	 * @return
	 */
	@Bean//由此注解描述的方法会交给spring框架管理，默认bean的名字为方法名
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		return securityManager;
	}
	/**
	 *  配置ShiroFilterFactoryBean对象
	 *  基于此对象创建过滤器工厂，通过过滤器工厂创建过滤器，通过过滤器对请求进行过滤
	 * @param securityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager){
		ShiroFilterFactoryBean sBean=new ShiroFilterFactoryBean();
		//设置安全管理器
		sBean.setSecurityManager(securityManager);
		//END:设置登录URL
		sBean.setLoginUrl("/doLoginUI");
		//设置过滤规则
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		//静态资源允许匿名访问：”anon“
		 map.put("/bower_components/**","anon");
         map.put("/build/**","anon");
         map.put("/dist/**","anon");
         map.put("/plugins/**","anon");
         //除了匿名访问的资源，其他都需要认证（”authc“）访问
         map.put("/**", "authc");
         sBean.setFilterChainDefinitionMap(map);//设置过滤器链定义图
         return sBean;
	}
}
