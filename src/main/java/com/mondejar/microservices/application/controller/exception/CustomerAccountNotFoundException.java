package com.mondejar.microservices.application.controller.exception;

@SuppressWarnings("serial")
public class CustomerAccountNotFoundException extends RuntimeException{
	
	private static final String CUSTOMER_ACCOUNT_NOT_FOUND = "Customer Account not found.";
	
	public CustomerAccountNotFoundException() {
		super(CUSTOMER_ACCOUNT_NOT_FOUND);
	}
}
