package com.cy.pj.shopping.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShoppingServiceTests {
	@Autowired
	private ShoppingService shoppingService;
	@Test
	public void testtoPayService() {
		shoppingService.toPayservice();
	}
}
