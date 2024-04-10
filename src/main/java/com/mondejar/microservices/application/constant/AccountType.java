package com.mondejar.microservices.application.constant;

public enum AccountType {
	S("Savings"), 
	C("Checking");
	
	private final String accountType;
	
	private AccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getValue() {
		return accountType;
	}
}
