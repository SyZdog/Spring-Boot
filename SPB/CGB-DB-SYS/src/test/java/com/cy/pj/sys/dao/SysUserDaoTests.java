package com.cy.pj.sys.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.vo.SysUserDeptVo;

@SpringBootTest
public class SysUserDaoTests {
	@Autowired
	private SysUserDao sysUserDao;
	@Test
	public void testGetRowCount() {
		List<SysUserDeptVo> list = sysUserDao.findPageObjects(null, 0, 3);
		for (SysUserDeptVo user : list) {
			System.out.println(user);
		}
		int rowCount = sysUserDao.getRowCount(null);
		System.out.println(rowCount);
	}

}
