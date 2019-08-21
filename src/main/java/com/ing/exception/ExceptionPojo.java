package com.ing.exception;

import java.io.Serializable;

public class ExceptionPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private int statusCode;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionPojo(String message) {
		super();
		this.message = message;
	}
	

}
