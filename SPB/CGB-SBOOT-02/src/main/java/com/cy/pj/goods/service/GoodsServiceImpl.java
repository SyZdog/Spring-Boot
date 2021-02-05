package com.cy.pj.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;
@Service
public class GoodsServiceImpl implements GoodsService {
/*
 * 商品业务层对象，业务逻辑处理
 * 
 * */
	@Autowired
	private GoodsDao goodsDao;
	@Override
	public List<Goods> selectAll() {
		long start=System.currentTimeMillis();
		List<Goods> list = goodsDao.selectAll();
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end-start));
		return list;
	}

}
