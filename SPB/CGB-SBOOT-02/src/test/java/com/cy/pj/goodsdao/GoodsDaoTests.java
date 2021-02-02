package com.cy.pj.goodsdao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.goods.GoodsDao;

@SpringBootTest
public class GoodsDaoTests {
	@Autowired
	private GoodsDao goodsDao;
	@Test
	public void testDeleteById() {
		int rows = goodsDao.deleteById(1);
		System.out.println("影响行数为："+rows);
	}
}
