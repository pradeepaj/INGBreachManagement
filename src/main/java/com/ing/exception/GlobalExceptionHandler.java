package com.ing.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exception.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ExceptionPojo> globalExceptionHandler(UserNotFound ex, WebRequest request) {

		ExceptionPojo user = new ExceptionPojo(ex.getMessage());
		user.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ExceptionPojo>(user, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EnterValidCredentials.class)
	public ResponseEntity<ExceptionPojo> globalExceptionHandler(EnterValidCredentials ex, WebRequest request) {

		ExceptionPojo user = new ExceptionPojo(ex.getMessage());
		user.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ExceptionPojo>(user, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BreachManagementException.class)
	public ResponseEntity<ExceptionPojo> globalExceptionHandler(BreachManagementException ex, WebRequest request) {

		ExceptionPojo user = new ExceptionPojo(ex.getMessage());
		return new ResponseEntity<ExceptionPojo>(user, HttpStatus.NOT_FOUND);
	}
	
	

}