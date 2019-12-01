package com.nci.model;

public class Status {

	private String message;
	private String code;

	public Status(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

}
