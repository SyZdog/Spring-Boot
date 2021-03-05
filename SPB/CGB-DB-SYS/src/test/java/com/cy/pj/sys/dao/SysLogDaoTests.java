package com.cy.pj.sys.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.entity.SysLog;

@SpringBootTest
public class SysLogDaoTests {
	@Autowired
	private SysLogDao sysLogDao;
	@Test
	//总记录数
	public void testGetRowCount() {
		int rowCount = sysLogDao.getRowCount(null);
		System.out.println("rowCount:"+ rowCount);
	}
	@Test
	//封装结果
	public void testFindPageObject() {
		List<SysLog> list =sysLogDao.findPageObject(null, 0, 5);
		for (SysLog log : list) {
			System.out.println(log);
		}
	}
}
