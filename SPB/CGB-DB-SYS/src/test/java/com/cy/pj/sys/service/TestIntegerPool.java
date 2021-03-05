package com.cy.pj.sys.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//测试Long长整型在内存中也有整数池
@SpringBootTest
public class TestIntegerPool {
	@Test
	public void testIntegerCache() {
		Integer t1 = 100;//Integer.valueOf(100)
		Integer t2 = 100;
		System.out.println(t1 == t2);//true
		//对于Integer类有一个整数池（-128~+127）
		Integer t3 = 200;//Integer.valueOf(200)
		Integer t4 = 200;
		System.out.println(t3 == t4);//false
	}
	@Test
	public void testLongCache() {
		Long l1 = 100L;
		Long l2 = 100L;
		//证明long类型也有整数池
		System.out.println(l1 == l2);//true
		Long l3 = 200L;
		Long l4 = 200L;
		System.out.println(l3 == l4);//false
		
	}
}
