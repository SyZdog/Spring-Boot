package com.cy.pj.common.exception;
//创建异常类
public class ServiceException extends RuntimeException {
	//右键source--Generate Constructors from superclass
	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
