package com.cy.pj.goods.dao;

import java.sql.Date;

public class Goods {
	private Integer id;
	private String name;
	private Date createdTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", createdTime=" + createdTime + "]";
	}
	
	
}
