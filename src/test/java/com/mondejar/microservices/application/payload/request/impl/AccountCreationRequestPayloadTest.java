package com.mondejar.microservices.application.payload.request.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mondejar.microservices.application.service.impl.AccountCreationService;

@SpringBootTest
public class AccountCreationRequestPayloadTest {
	
	private static final String VALID_CUSTOMER_NAME = "Denmark";
	private static final String VALID_MOBILE_NUMBER = "099999999999";
	private static final String VALID_EMAIL = "test@gmail.com";
	private static final String VALID_ADDRESS_1 ="Metro Manila";
	private static final String VALID_ADDRESS_2 = "Philippines";
	private static final String VALID_ACCOUNT_TYPE = "S";
	private static final String MORE_THAN_100_CHARS = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
	private static final String INVALID_EMAIL = "testgmail";
	private static final String INVALID_ACCOUNT_TYPE = "T";
	private static final String EMPTY_VALUE = "";
	private static final String NULL_VALUE = null;
	
	@Autowired
	private AccountCreationService accountCreationService;
}
