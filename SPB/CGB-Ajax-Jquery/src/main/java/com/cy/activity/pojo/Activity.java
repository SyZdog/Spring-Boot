package com.cy.activity.pojo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//@Setter
//@Getter
//@ToString
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//实体类，用来封装数据库中的数据
public class Activity {
	private Long id;
	private String title;//活动主体
	private String category;//活动类别
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private LocalDateTime startTime;//开始时间
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private LocalDateTime endTime;//结束时间
	private Short state=1;//1 有效状态
	private String remark;//评述
	private String createdUser;//创建用户
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private LocalDateTime createdTime;//记录创建时间	
}
