package com.example.demo.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.payload.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	 @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Unexpected Error", details);
	        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	   
	 
	    @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	            details.add(error.getDefaultMessage());
	        }
	        ErrorResponse error = new ErrorResponse("Validation Failed", details);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(InvalidIpLocationException.class)
	    public final ResponseEntity<Object> handleInvalidLocationException(InvalidIpLocationException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Invalid IP location", details);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	    }
	    @ExceptionHandler(InternalServerException.class)
	    public final ResponseEntity<Object> handleInternalSererError(InternalServerException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        ErrorResponse error = new ErrorResponse("Internal Server Error", details);
	        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
