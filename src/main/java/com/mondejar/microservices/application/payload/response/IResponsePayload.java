package com.mondejar.microservices.application.payload.response;

public interface IResponsePayload {
	
	public Integer getTransactionStatusCode();
	
	public void setTransactionStatusCode(Integer transactionStatusCode);
	
	public String getTransactionStatusDescription();
	
	public void setTransactionStatusDescription(String transactionStatusDescription);
}
