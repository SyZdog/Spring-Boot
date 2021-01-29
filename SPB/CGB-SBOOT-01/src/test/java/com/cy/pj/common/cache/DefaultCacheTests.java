package com.cy.pj.common.cache;
//测试spring给DefaCache类创建的对象

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//@SpringBootTest注解描述类为一个单元测试类，并且此测试类交给spring管理
@SpringBootTest
public class DefaultCacheTests {
	/*
	 * @Autowired:自动装配
	 * 
	 * */
	@Autowired
	private DefaultCache defaultCache;
	@Autowired
	private DefaultCache defaultCache1;
	@Test
	public void testDefaultCacheTests() {
		System.out.println(defaultCache);//从spring容器中获取DefaultCache对象的内存地址值
	}
}
