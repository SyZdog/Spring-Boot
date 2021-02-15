package com.cy.activity.pojo;

import java.time.LocalDateTime;

//实体类，用来封装数据库中的数据
public class Activity {
	private Long id;
	private String title;//活动主体
	private String category;//活动类别
	private LocalDateTime startTime;//开始时间
	private LocalDateTime endTime;//结束时间
	private Short state=1;//1 有效状态
	private String remark;//评述
	private String createdUser;//创建用户
	private LocalDateTime createdTime;//记录创建时间
	
	//提供set方法和get方法
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	
	//重写tostring
	@Override
	public String toString() {
		return "Activity [id=" + id + ", title=" + title + ", category=" + category + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", state=" + state + ", remark=" + remark + ", createdUser=" + createdUser
				+ ", createdTime=" + createdTime + "]";
	}
	
	
}
