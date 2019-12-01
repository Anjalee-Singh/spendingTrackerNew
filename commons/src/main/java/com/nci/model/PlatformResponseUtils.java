package com.nci.model;

import static com.expense.exception.ResponseCode.getStatus;

import org.springframework.http.HttpStatus;

import com.expense.exception.ResponseCode;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Utility class for handling
 * <code>com.jci.srv.model.platform.PlatformResponse</code>
 *
 */
public final class PlatformResponseUtils {

	private static final String HTTP_STATUS_OK = String.valueOf(HttpStatus.OK.value());
	private static final String OP_COMPLETED = "Operation completed";
	private static final Status STATUS = new Status(HTTP_STATUS_OK, OP_COMPLETED);

	public static PlatformResponse generateForError(String errCode, String errMsg) {
		Status status = new Status(errCode, errMsg);
		PlatformResponse resp = new PlatformResponse(status, null);
		return resp;
	}
	public static PlatformResponse generateForTemplateError(String errCode, String errMsg) {
		Status status = new Status(errCode, errMsg);
		PlatformResponse resp = new PlatformResponse(status, null);
		return resp;
	}

}
