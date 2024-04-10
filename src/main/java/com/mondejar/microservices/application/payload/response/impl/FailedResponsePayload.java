package com.mondejar.microservices.application.payload.response.impl;

import java.util.List;

import com.mondejar.microservices.application.payload.response.IResponsePayload;

public class FailedResponsePayload implements IResponsePayload{
	
	private Integer transactionStatusCode;
	private String transactionStatusDescription;
	
	public FailedResponsePayload(Integer transactionStatusCode, String transactionStatusDescription) {
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	
	public FailedResponsePayload(Integer transactionStatusCode, List<String> errorMessages) {
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = errorMessagesToString(errorMessages);
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
	
	private String errorMessagesToString(List<String> errorMessages) {
		String errorMessagesStr = "";

		for (String errorMessage:errorMessages) {
			errorMessagesStr = errorMessagesStr.concat("[" + errorMessage + "]");
		}
		
		return errorMessagesStr;
	}
}
