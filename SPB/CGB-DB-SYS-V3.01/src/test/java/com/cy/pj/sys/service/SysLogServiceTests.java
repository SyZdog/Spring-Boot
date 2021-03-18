package com.cy.pj.sys.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

@SpringBootTest
public class SysLogServiceTests {
	@Autowired
	private SysLogService sysLogService;
	@Test
	public void testFindObject() {
		PageObject<SysLog> pageObject = sysLogService.findPageObject("admin", 3L);
		System.out.println(pageObject);
	}
}
