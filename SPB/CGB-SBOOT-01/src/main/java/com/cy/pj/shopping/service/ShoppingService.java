package com.cy.pj.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShoppingService {
	@Autowired
	@Qualifier("weiXinPayService")
	private PayService payService;
	//定义一个去支付的方法
	public void toPayservice() {
		payService.pay();
	}
}
