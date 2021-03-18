package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysRole implements Serializable{
	
	private static final long serialVersionUID = 5444781487816683086L;
	private Integer id;
    private String name;
    private String note;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
