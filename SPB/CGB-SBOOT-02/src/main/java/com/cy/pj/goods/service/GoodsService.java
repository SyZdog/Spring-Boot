package com.cy.pj.goods.service;

import java.util.List;

import com.cy.pj.goods.pojo.Goods;

public interface GoodsService {
	//新增一条商品信息
	int saveGoods(Goods goods);
	//基于id删除商品信息
	int deleteById(Long id);
	//定义查询业务的方法
	List<Goods> selectAll();
}
