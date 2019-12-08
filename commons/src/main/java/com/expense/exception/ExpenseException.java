package com.expense.exception;

public class ExpenseException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4981198520410309384L;
	private ErrorCode errorCode;
	private String errorMsg;
	
	public ExpenseException(String message) {
		super(message);
	}

	public ExpenseException(String message , Throwable t) {
		super(message);
	}
	
	public ExpenseException(String message , Throwable t , ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
		this.errorMsg = message;
	}
	
	public ExpenseException( ErrorCode errorCode, String message) {
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
