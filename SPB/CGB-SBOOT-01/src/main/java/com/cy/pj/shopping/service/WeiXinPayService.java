package com.cy.pj.shopping.service;

import org.springframework.stereotype.Component;

@Component
public class WeiXinPayService implements PayService {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("WeiXinPayService.pay()");
	}

}
