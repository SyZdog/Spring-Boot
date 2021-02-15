package com.cy.pj.goods.controller.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
/*
 * @Controller注解的作用
 * 1.表明当前为控制层
 * 2.将@Controller注解所描述的类交给spring容器管理
 * */
@Controller
public class GoodsController {
	//访问路径
	//localhost:8080/doGoodsUI
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("doSaveGoods")
	public String doSaveGoods(Goods goods) {
		int rows = goodsService.saveGoods(goods);
		return "redirect:doGoodsUI";
		
	}
	
	@RequestMapping("doDeleteById")
	public String doDeleteById(Long id) {
		goodsService.deleteById(id);
		return "redirect:doGoodsUI";
	}
	
	@RequestMapping("doGoodsUI")
	public String doGoodsUI(Model model) {
		/*
		 * 通过return返回前端控制器，前端控制器会将goods字符串交给视图解析器
		 * 视图解析器是有thymeleaf提供
		 * thymeleaf中的视图解析器会对goods字符串添加前缀和后缀
		 * */
		List<Goods> list = goodsService.selectAll();
		//将数据存入到model域中
		model.addAttribute("goods", list);
		return "goods";
		
	}
}
