package com.cy.pj.shopping.service;

import org.springframework.stereotype.Component;

@Component
public class CardPayService implements PayService {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("CardPayService.pay()");
	}

}
