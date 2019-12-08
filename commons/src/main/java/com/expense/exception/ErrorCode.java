package com.expense.exception;

public enum ErrorCode {

	READ_PDF_ERROR("ERR1001"),
	INVAID_INPUT_ERROR("ERR1002"),
	ASYNC_TIMEOUT_ERROR("ERR1004"),
	GENERAL_ERROR("ERR1006"),
	GENERAL_RESOURCE_NOT_FOUND("ERR1007"),
	INVALID_INPUT_FORMAT("ERR1008"),
	USER_VALIDATION_FAIL("ERR003"),
	INVALID_INPUT_REQUEST("ERR1009"),
	PDF_NOT_FOUND("ERR1003");
	
	private ErrorCode(String code) {
		this.code = code;
	}

	private String code;

	public String getCode() {
		return code;
	}

}
