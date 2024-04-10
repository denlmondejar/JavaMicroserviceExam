package com.mondejar.microservices.application.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.mondejar.microservices.application.entity.Customer;
import com.mondejar.microservices.application.payload.request.impl.AccountCreationRequestPayload;
import com.mondejar.microservices.application.payload.response.impl.AccountCreationResponsePayload;
import com.mondejar.microservices.application.repository.ICustomerRepository;
import com.mondejar.microservices.application.service.ICustomerService;

@Service("accountCreationService")
@Transactional
public class AccountCreationService implements ICustomerService {
	
	private static final String CUSTOMER_ACCOUNT_CREATED = "Customer account created.";
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	private Customer customer;
	
	public ResponseEntity<AccountCreationResponsePayload> getResponse(@Valid @RequestBody AccountCreationRequestPayload requestPayload) {
		customer = new Customer();
		customer.setCustomerName(requestPayload.getCustomerName());
		customer.setCustomerMobile(requestPayload.getCustomerMobile());
		customer.setCustomerEmail(requestPayload.getCustomerEmail());
		customer.setAddress1(requestPayload.getAddress1());
		customer.setAddress2(requestPayload.getAddress2());
		customer.setAccountType(requestPayload.getAccountType().getValue());
		
		customerRepository.save(customer);
		
		return new ResponseEntity<>(new AccountCreationResponsePayload(customer.getCustomerNumber(), 
				HttpStatus.CREATED.value(), CUSTOMER_ACCOUNT_CREATED), HttpStatus.CREATED);
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
