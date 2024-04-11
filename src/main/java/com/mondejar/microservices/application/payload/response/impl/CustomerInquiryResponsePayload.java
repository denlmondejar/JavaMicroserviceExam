package com.mondejar.microservices.application.payload.response.impl;

import java.util.Map;

import com.mondejar.microservices.application.payload.response.IResponsePayload;

public class CustomerInquiryResponsePayload implements IResponsePayload {
	
	private Long customerNumber;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String address1;
	private String address2;
	private Map<String, String> accountDetails;
	private Integer transactionStatusCode;
	private String transactionStatusDescription;
	
	public CustomerInquiryResponsePayload() {}
	
	public CustomerInquiryResponsePayload(Long customerNumber, String customerName, String customerMobile,
			String customerEmail, String address1, String address2, Map<String, String> accountDetails,
			Integer transactionStatusCode, String transactionStatusDescription) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.address1 = address1;
		this.address2 = address2;
		this.accountDetails = accountDetails;
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Map<String, String> getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(Map<String, String> accountDetails) {
		this.accountDetails = accountDetails;
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
