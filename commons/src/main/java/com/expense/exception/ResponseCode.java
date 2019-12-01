package com.expense.exception;

import org.springframework.http.HttpStatus;

public class ResponseCode {
	public static HttpStatus getStatus(ErrorCode errorCode) {

		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		
		switch (errorCode) {
			case READ_PDF_ERROR:
				httpStatus = HttpStatus.NOT_FOUND;
				break;
			
			case INVAID_INPUT_ERROR:
				httpStatus = HttpStatus.BAD_REQUEST;
				break;
		}
		return httpStatus;
	}

}
