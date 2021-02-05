package com.cy.pj.goods.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.goods.pojo.Goods;


@SpringBootTest
public class GoodsServiceTests {
	@Autowired
	private GoodsService goodsService;
	@Test
	public void testFindGoods() {
		List<Goods> list =goodsService.selectAll();
		for (Goods goods : list) {
			System.out.println(goods);
		}
		
	}
}
