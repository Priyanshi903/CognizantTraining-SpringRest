package com.cognizant.springlearn.GlobalExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.springlearn.SpringLearnApplication;


/*logs of CountryController is not present, which means that the global 
exception handler method is called if there are validation errors and the 
controller method is not invoked.*/

@ControllerAdvice
public class CountryGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.info("Start");
		// Map that contains the error details
		 Map<String, Object> body = new LinkedHashMap<>();
		 body.put("timestamp", new Date());
		 body.put("status", status.value());
		 // Get all validation errors
		 List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		 // Add errors to the response map 
		 body.put("errors", errors);
		 LOGGER.info("End");
		 return new ResponseEntity<>(body, headers, status);

	}

}
