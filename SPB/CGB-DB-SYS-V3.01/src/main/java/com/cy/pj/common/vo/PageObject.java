package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable{
	private static final long serialVersionUID = -4338960814253964934L;
	//封装查询到的当前页记录
	private List<T> records;
	//总记录数
	private Long rowCount;
	//总页数
	private Long pageCount;
	//页面大小
	private Integer pageSize;
	//当前页码值
	private Long pageCurrent;
	//创建全参构造函数
	public PageObject(List<T> records, Long rowCount, Integer pageSize, Long pageCurrent) {
		super();
		this.records = records;
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.pageCurrent = pageCurrent;
		//计算记录的总页数
//		this.pageCount=rowCount/pageSize;
//		if(rowCount/pageCurrent != 0) {
//			this.pageCount++;
//		}
		this.pageCount=(rowCount-1)/pageSize+1;
	}
	
}
