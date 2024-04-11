package com.mondejar.microservices.application.controller.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mondejar.microservices.application.payload.response.impl.FailedResponsePayload;

@ControllerAdvice
public class MicroservicesControllerAdvice {
	
	private static final String NOT_VALID_EXCEPTION = "MethodArgumentNotValidException: ";
	
	private final Logger logger = LoggerFactory.getLogger(MicroservicesControllerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<FailedResponsePayload> handleException(Exception exception) {
		logger.warn(exception.getMessage());
		
		return new ResponseEntity<>(new FailedResponsePayload(HttpStatus.BAD_REQUEST.value(), exception.getLocalizedMessage()), 
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<FailedResponsePayload> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
		logger.warn(exception.getMessage());
		
		return new ResponseEntity<>(new FailedResponsePayload(HttpStatus.BAD_REQUEST.value(), exception.getLocalizedMessage()), 
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<FailedResponsePayload> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		List<String> errorMessages = exception.getFieldErrors()
				.stream()
				.map(fieldError -> fieldError.getDefaultMessage())
				.collect(Collectors.toList());
		
		for (String errorMessage:errorMessages) {
			logger.warn(NOT_VALID_EXCEPTION + errorMessage);
		}
		
		return new ResponseEntity<>(new FailedResponsePayload(HttpStatus.BAD_REQUEST.value(), errorMessages), 
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerAccountNotFoundException.class)
	public ResponseEntity<FailedResponsePayload> handleCustomerAccountNotFoundException(CustomerAccountNotFoundException exception) {
		logger.warn(exception.getMessage());
		
		return new ResponseEntity<>(new FailedResponsePayload(HttpStatus.NOT_FOUND.value(), exception.getLocalizedMessage()), 
				HttpStatus.NOT_FOUND);
	}
}
