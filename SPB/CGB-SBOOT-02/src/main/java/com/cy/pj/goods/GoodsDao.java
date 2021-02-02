package com.cy.pj.goods;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
/*
 * DAO(Date Access Object)：数据访问对象
 * GoodsDao用来表示商品表对应的数据访问对象
 * @Mapper注解用来描述数据层的接口，并且@Mapper是有Mybatis框架
 * 定义的。
 * 通过此注解描述的接口，系统底层会为其创建实现类，并且会创建实现类的对象
 * 然后交给spring框架去管理
 * */
@Mapper
public interface GoodsDao {
	/*
	 * 基于id去删除商品信息
	 * */
	//通过注解声明动态SQL
	@Delete("delete from tb_goods where id=#{id}")
	int deleteById(Integer id);
}
