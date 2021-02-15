package com.cy.pj.goods.service;

import java.util.List;
import java.util.NoSuchElementException;

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
	public int deleteById(Long id) {
		// 对接收到id值，进行合法判断
		if (id == null || id < 1) 
			throw new IllegalArgumentException("id值无效！");
		int rows = goodsDao.deleteById(id);
		if (rows == 0) 
			throw new NoSuchElementException("记录可能不存在了！");
		return rows;
	}
	
	@Override
	public List<Goods> selectAll() {
		long start=System.currentTimeMillis();
		List<Goods> list = goodsDao.selectAll();
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end-start));
		return list;
	}

	@Override
	public int saveGoods(Goods goods) {
		int rows = goodsDao.insertGoods(goods);
		return rows;
	}

}
