package com.cy.pj.common.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataSourceTests {
	@Autowired
	private DataSource dataSource;
	@Test
	public void testConnection() throws Exception {
		//通过getConnection()获取去连接一个对象
		Connection conn = dataSource.getConnection();
		//HikariProxyConnection@2089104518 
		//wrapping com.mysql.cj.jdbc.ConnectionImpl@174e1b69
		System.out.println(conn);
	}
}
