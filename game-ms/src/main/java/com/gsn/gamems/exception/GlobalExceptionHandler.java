package com.gsn.gamems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public void handleCustomException(HttpServletResponse res, NotFoundException ex) throws IOException {
		res.sendError(ex.getHttpStatus().value(), ex.getMessage());
	}

}
