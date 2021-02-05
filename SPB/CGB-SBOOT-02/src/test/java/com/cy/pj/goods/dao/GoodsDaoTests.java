package com.cy.pj.goods.dao;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;

@SpringBootTest
public class GoodsDaoTests {
	@Autowired
	private GoodsDao goodsDao;
	//测试基于多个id删除商品信息
	@Test
	public void testDeleteByIds() {
		int rows = goodsDao.deleteByIds(5,6,7);
		System.out.println("影响行数为："+rows);
	}
	@Test
	public void testDeleteById() {
		int rows = goodsDao.deleteById(1);
		System.out.println("影响行数为："+rows);
	}
}
