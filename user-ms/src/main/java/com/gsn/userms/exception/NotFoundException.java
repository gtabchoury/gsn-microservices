package com.gsn.userms.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;
	private final HttpStatus httpStatus;

	public NotFoundException(String message) {
		this.message = message;
		this.httpStatus = HttpStatus.NOT_FOUND;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
