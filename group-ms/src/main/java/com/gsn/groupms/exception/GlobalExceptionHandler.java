package com.gsn.groupms.exception;

import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public void handleCustomException(HttpServletResponse res, FeignException ex) throws IOException {
		res.sendError(ex.status(), ex.contentUTF8());
	}

}
