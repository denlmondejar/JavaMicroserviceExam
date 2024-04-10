package com.mondejar.microservices.application.payload.response.impl;

import com.mondejar.microservices.application.payload.response.IResponsePayload;

public class AccountCreationResponsePayload implements IResponsePayload{
	
	private Long customerNumber;
	private Integer transactionStatusCode;
	private String transactionStatusDescription;

	public AccountCreationResponsePayload(Long customerNumber, Integer transactionStatusCode,
			String transactionStatusDescription) {
		this.customerNumber = customerNumber;
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	
	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public Integer getTransactionStatusCode() {
		return transactionStatusCode;
	}
	@Override
	public void setTransactionStatusCode(Integer transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}
	@Override
	public String getTransactionStatusDescription() {
		return transactionStatusDescription;
	}
	@Override
	public void setTransactionStatusDescription(String transactionStatusDescription) {
		this.transactionStatusDescription = transactionStatusDescription;
	}
}
