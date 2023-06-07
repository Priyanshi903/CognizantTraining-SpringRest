package com.cognizant.moviecruiser.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAOP extends ResponseEntityExceptionHandler{
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {MovieNotFound.class,FavouritesEmptyException.class,UserNotFoundException.class})
	public ErrorInfo exceptionHandler(Exception exception,HttpServletRequest request) {
		String mssg=exception.getMessage();
		String uri=request.getRequestURI();
		return new ErrorInfo(uri, mssg);
	}
	
}
