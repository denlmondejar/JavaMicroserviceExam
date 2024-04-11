package com.mondejar.microservices.application.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mondejar.microservices.application.controller.exception.CustomerAccountNotFoundException;
import com.mondejar.microservices.application.payload.request.impl.AccountCreationRequestPayload;
import com.mondejar.microservices.application.payload.response.impl.AccountCreationResponsePayload;
import com.mondejar.microservices.application.payload.response.impl.CustomerInquiryResponsePayload;
import com.mondejar.microservices.application.service.impl.AccountCreationService;
import com.mondejar.microservices.application.service.impl.CustomerInquiryService;

@RestController
@RequestMapping("/api/v1")
public class MicroservicesController {
	
	@Autowired
	@Qualifier("accountCreationService")
	private AccountCreationService accountCreationService;
	
	@Autowired
	@Qualifier("customerInquiryService")
	private CustomerInquiryService customerInquiryService;
	
	@PostMapping("/account")
	public ResponseEntity<AccountCreationResponsePayload> createNewCustomerAccount(@Valid @RequestBody AccountCreationRequestPayload newCustomerAccount) {
		return accountCreationService.getResponse(newCustomerAccount);
	}
	
	@GetMapping("/account/{customerNumber}")
	public ResponseEntity<CustomerInquiryResponsePayload> searchCustomerAccount(@PathVariable Long customerNumber) throws CustomerAccountNotFoundException{
		return customerInquiryService.getResponse(customerNumber);
	}
}