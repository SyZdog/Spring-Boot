package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
//@SpringBootTest注解描述类为一个单元测试类，并且此测试类交给spring管理
@SpringBootTest
public class CacheTest {
	//@Autowired：自动装配，描述属性时，表示此属性的值要由spring框架进行注入
	/*
	 * Qualifier的意思是合格者，通过这个标示，表明了哪个实现类才是
	 * 我们所需要的；！！不能描述构造方法！！
	 * @Autowired默认安装类型匹配注入Bean，如果有多个实现类,
	 * 搭配@Qualifier（“实现类名称首字母小写”）表明注入的是哪一个实现类的Bean
	 * */
	//@Autowired
	//@Qualifier("defaultCache")//合格者
	private Cache cache01;
	//@Autowired
	//@Qualifier("weakCache")
	private Cache cache02;
	//通过构造方法为属性赋值（构造注入)	
	@Autowired
	public CacheTest(@Qualifier("defaultCache")Cache cache01,@Qualifier("weakCache")Cache cache02) {
		// TODO Auto-generated constructor stub
		this.cache01 = cache01;
		this.cache02 = cache02;
	}
	@Test
	public void testCache01() {
		System.out.println(cache01);
		System.out.println(cache02);
	}
}
