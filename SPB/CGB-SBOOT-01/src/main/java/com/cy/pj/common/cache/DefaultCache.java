package com.cy.pj.common.cache;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
//利用注解，把DefaultCache类在spring容器中创建一个对象
import org.springframework.stereotype.Component;
//将类交给Spring去管理有两种方式：XML配置文件形式和注解
/*
 * @Component该注解主要用于告诉Spring框架该注解当前所描述的类交给Spring去管理
 * 相当于<bean id="DefaultCache" class="com.cy.pj.common.cache.DefaultCache">
 * 
 */
/*
 * @Lazy注解：表示延迟加载，也就是之前我们学习单例设计模式时的懒汉式
 * （用的时候才创建对象这样可以减少内存消耗）
 *默认情况下不写@Lazy时实时加载的，就是加载类的时候就创建对象,
 *也就是只要你启动项目，就会创建
 *@Lazy(true)表示延时加载，@Lazy(false)表示实时加载
 */

/*
 * @Scope注解：表示作用域，singleton（默认）表示单例，prototype表示多例
 * */
@Component
@Scope("prototype")
@Lazy(false)
public class DefaultCache implements Cache{
	public DefaultCache() {
		System.out.println("==DefaultCache==");
	}
	@PostConstruct//生命周期初始化方法，在对象构建以后执行，用于初始化一些资源
    public void init() {
            System.out.println("init()");
    }
	 @PreDestroy//生命周期销毁方法，对象销毁之前执行，用于释放一些资源
	    public void destory() {
	            System.out.println("destory()");
	    }
}
