package com.mondejar.microservices.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mondejar.microservices.application.payload.request.impl.AccountCreationRequestPayload;
import com.mondejar.microservices.application.payload.response.impl.AccountCreationResponsePayload;
import com.mondejar.microservices.application.service.impl.AccountCreationService;

@RestController
@RequestMapping("/api/v1")
public class MicroservicesController {
	
	@Autowired
	@Qualifier("accountCreationService")
	private AccountCreationService accountCreationService;
	
	@PostMapping("/account")
	public ResponseEntity<AccountCreationResponsePayload> createNewCustomerAccount(@Valid @RequestBody AccountCreationRequestPayload newCustomerAccount) {
		return accountCreationService.getResponse(newCustomerAccount);
	}
}