package com.tharun.Exceptions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



//To handle exceptions globally and provide unified structure response
@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) 
 	{
		log.info("Log --> inside GlobalExceptionHandler");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	
	 
}
