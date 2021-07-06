package com.expense.exception;

public class NCIException extends RuntimeException 
{
	private ErrorCode errorCode;
	private String errorMsg;
	
	public NCIException(String message) {
		super(message);
	}

	public NCIException(String message , Throwable t) {
		super(message);
	}
	
	public NCIException(String message , Throwable t , ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
		this.errorMsg = message;
	}
	
	public NCIException( ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.errorMsg = message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
	
}
