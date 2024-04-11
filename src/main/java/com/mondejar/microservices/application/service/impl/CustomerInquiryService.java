package com.mondejar.microservices.application.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mondejar.microservices.application.controller.exception.CustomerAccountNotFoundException;
import com.mondejar.microservices.application.entity.AccountDetails;
import com.mondejar.microservices.application.entity.Customer;
import com.mondejar.microservices.application.payload.response.impl.CustomerInquiryResponsePayload;
import com.mondejar.microservices.application.repository.IAccountDetailsRepository;
import com.mondejar.microservices.application.repository.ICustomerRepository;
import com.mondejar.microservices.application.service.ICustomerService;

@Service("customerInquiryService")
public class CustomerInquiryService implements ICustomerService {
	
	private static final String CUSTOMER_ACCOUNT_FOUND = "Customer Account found.";
	private static final String ACCOUNT_NUMBER = "accountNumber";
	private static final String ACCOUNT_TYPE = "accountType";
	private static final String AVAILABLE_BALANCE = "availableBalance";
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IAccountDetailsRepository accountDetailsRepository;
	
	private Customer customer;
	
	public ResponseEntity<CustomerInquiryResponsePayload> getResponse(@PathVariable Long customerNumber) throws CustomerAccountNotFoundException {
		CustomerInquiryResponsePayload customerInquiryResponsePayload = new CustomerInquiryResponsePayload();
		
		Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
		
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			AccountDetails accountDetails = accountDetailsRepository.findById(customerNumber).get();
			
			customerInquiryResponsePayload.setCustomerNumber(customerNumber);
			customerInquiryResponsePayload.setCustomerName(customer.getCustomerName());
			customerInquiryResponsePayload.setCustomerMobile(customer.getCustomerMobile());
			customerInquiryResponsePayload.setCustomerEmail(customer.getCustomerEmail());
			customerInquiryResponsePayload.setAddress1(customer.getAddress1());
			customerInquiryResponsePayload.setAddress2(customer.getAddress2());
			
			Map<String, String> accountDetailsMap = new HashMap<>();
			accountDetailsMap.put(ACCOUNT_NUMBER, String.valueOf(accountDetails.getAccountNumber()));
			accountDetailsMap.put(ACCOUNT_TYPE, accountDetails.getAccountType());
			accountDetailsMap.put(AVAILABLE_BALANCE, String.valueOf(accountDetails.getAvailableBalance()));
			customerInquiryResponsePayload.setAccountDetails(accountDetailsMap);
			
			customerInquiryResponsePayload.setTransactionStatusCode(HttpStatus.FOUND.value());
			customerInquiryResponsePayload.setTransactionStatusDescription(CUSTOMER_ACCOUNT_FOUND);
		} else {
			throw new CustomerAccountNotFoundException();
		}
		
		return new ResponseEntity<>(customerInquiryResponsePayload, HttpStatus.FOUND);
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
