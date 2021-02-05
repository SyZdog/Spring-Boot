package com.cy.pj.goods.pojo;

import java.util.Date;

/*ORM(对象关系映射）：表与实体类的映射，表记录和实体对象的映射
 * pojo对象，基于此对象封装从数据库查询到的数据
 * */


public class Goods {
	private Long id;//id bigint primary key auto_increment
	private String name;//name varchar(100) not null
	private String remark;//remark text
	private Date createdTime;//createdTime datetime text
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", remark=" + remark + ", createdTime=" + createdTime + "]";
	}
	
	
}
