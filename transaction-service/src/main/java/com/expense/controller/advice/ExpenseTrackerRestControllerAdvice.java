package com.expense.controller.advice;

import static com.expense.exception.ErrorCode.GENERAL_ERROR;
import static com.expense.exception.ErrorCode.GENERAL_RESOURCE_NOT_FOUND;
import static com.expense.exception.ErrorCode.INVALID_INPUT_FORMAT;
import static com.expense.exception.ErrorCode.INVALID_INPUT_REQUEST;
import static com.expense.exception.ResponseCode.getStatus;
import static com.nci.model.PlatformResponseUtils.generateForError;
import static com.nci.model.PlatformResponseUtils.generateForTemplateError;

import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.thymeleaf.exceptions.TemplateInputException;

import com.expense.exception.NCIException;
import com.nci.model.PlatformResponse;

/**
 * Schema API centralized error handling to convert various exceptions with
 * relevant HTTP response codes
 *
 * @see <code>com.jci.srv.util.PlatformResponseUtils</code>
 * @see <code>com.jci.srv.exception.ResponseCode</code>
 */
@RestControllerAdvice
public class ExpenseTrackerRestControllerAdvice {

	private static final Logger LOGGER = LogManager.getLogger(ExpenseTrackerRestControllerAdvice.class);

	@ExceptionHandler(value = NCIException.class)
	public ResponseEntity<PlatformResponse> handleSrvException(NCIException e) {
		LOGGER.error("Handling SRVException - ", e);
		PlatformResponse resp = generateForError(e.getErrorCode().getCode(), e.getErrorMsg());
		return new ResponseEntity<>(resp, getStatus(e.getErrorCode()));
	}
	
	@ExceptionHandler(value = TemplateInputException.class)
	public ResponseEntity<PlatformResponse> handleTemplateException(TemplateInputException e) {
		LOGGER.error("Handling SRVException - ", e);
		PlatformResponse resp = generateForTemplateError(e.getTemplateName(), e.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.FAILED_DEPENDENCY);
	}

	@ExceptionHandler(value = ServletException.class)
	public ResponseEntity<PlatformResponse> handleServletException(ServletException e) {
		LOGGER.error("Handling ServletException - ", e);
		PlatformResponse resp = generateForError(GENERAL_ERROR.getCode(), e.getMessage());
		return new ResponseEntity<>(resp, getStatus(GENERAL_ERROR));
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<PlatformResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		LOGGER.error("Handling HttpMessageNotReadableException - ", e);
		PlatformResponse resp = generateForError(INVALID_INPUT_FORMAT.getCode(), "Invalid Input Error");
		return new ResponseEntity<>(resp, getStatus(INVALID_INPUT_FORMAT));
	}

	@ExceptionHandler(value = NoHandlerFoundException.class)
	public ResponseEntity<PlatformResponse> handleNoHandlerFoundException(NoHandlerFoundException e) {
		LOGGER.error("Handling NoHandlerFoundException - ", e);
		PlatformResponse resp = generateForError(GENERAL_RESOURCE_NOT_FOUND.getCode(), e.getMessage());
		return new ResponseEntity<>(resp, getStatus(GENERAL_RESOURCE_NOT_FOUND));
	}

	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<PlatformResponse> handleMethodArgMismatchException(MethodArgumentTypeMismatchException e) {
		LOGGER.error("Handling handleMethodArgMismatchException - ", e);
		PlatformResponse resp = generateForError(INVALID_INPUT_REQUEST.getCode(), "Invalid Input Error");
		return new ResponseEntity<>(resp, getStatus(INVALID_INPUT_REQUEST));
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<PlatformResponse> handleException(Exception e) {
		LOGGER.error("Handling exception - ", e);
		PlatformResponse resp = generateForError(GENERAL_ERROR.getCode(), "Server error");
		return new ResponseEntity<>(resp, getStatus(GENERAL_ERROR));
	}

}
