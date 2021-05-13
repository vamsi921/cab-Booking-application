package com.cg.mts.Exception;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest webRequest) {
		String bodyOfResponse = ex.getLocalizedMessage();
		return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<Object> handleAdminNotFoundException(AdminNotFoundException ex, WebRequest webRequest) {
		String message= ex.getLocalizedMessage();
		return new ResponseEntity(message, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DriverNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException(DriverNotFoundException ex, WebRequest webRequest) {
		String message= ex.getLocalizedMessage();
		return new ResponseEntity(message, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CabNotFoundException.class)
	public ResponseEntity<Object> handleCabNotFoundException(CabNotFoundException ex, WebRequest webRequest) {
		String bodyOfResponse = ex.getLocalizedMessage();
		return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	/*@ExceptionHandler(ConstraintViolationException.class) 
	public void  springHandleNotFound(HttpServletResponse response) throws IOException{
	  response.sendError(HttpStatus.BAD_REQUEST.value(),"Constraint issues"); 
	}
 
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public void  springMethodArgHandleIssue(HttpServletResponse response) throws IOException{
		  response.sendError(HttpStatus.BAD_REQUEST.value(), "Arguments mismatched......"); 
	}
	
	@ExceptionHandler(CustomerNotFoundException.class) 
	public void  springHandleNotFound1(HttpServletResponse response) throws IOException{
	  response.sendError(HttpStatus.NOT_FOUND.value(), "Customer Not Found!");
	}
	@ExceptionHandler(CustomerAlreadyExistsException.class) 
	public void  springHandleNotFound2(HttpServletResponse response) throws IOException{
	  response.sendError(HttpStatus.NOT_FOUND.value(), "Customer already exists");
	}*/
	

}





