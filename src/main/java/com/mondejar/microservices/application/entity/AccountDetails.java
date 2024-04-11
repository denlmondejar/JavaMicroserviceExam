package com.mondejar.microservices.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_DETAILS_TBL")
public class AccountDetails {
	
	@Id
	@Column(name = "CUSTOMER_NUMBER")
	private Long customerNumber;
	
	@Column(name = "ACCOUNT_NUMBER")
	private Long accountNumber;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name = "AVAILABLE_BALANCE")
	private Double availableBalance;
	
	public AccountDetails() {}

	public AccountDetails(Long customerNumber, Long accountNumber, String accountType, Double availableBalance) {
		this.customerNumber = customerNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
}
