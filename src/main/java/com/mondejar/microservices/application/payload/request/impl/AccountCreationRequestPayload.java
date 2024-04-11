package com.mondejar.microservices.application.payload.request.impl;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mondejar.microservices.application.constant.AccountType;
import com.mondejar.microservices.application.payload.request.IRequestPayload;

public class AccountCreationRequestPayload implements IRequestPayload{
	
	@NotBlank(message = "Name is required field.")
	@Size(max = 50, message = "Name should not exceed 50 characters.")
	private String customerName;
	
	@NotBlank(message = "Mobile Number is required field.")
	@Size(min = 3, max = 20, message = "Mobile Number should not exceed 20 characters.")
	private String customerMobile;
	
	@NotBlank(message = "Email is required field.")
	@Size(max = 50, message = "Email should not exceed 50 characters.")
	@Email(message = "Email must be well-formed.")
	private String customerEmail;
	
	@NotBlank(message = "Address 1 is required field.")
	@Size(max = 100, message = "Address 1 should not exceed 100 characters.")
	private String address1;
	
	@Size(max = 100, message = "Address 2 should not exceed 100 characters.")
	private String address2;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Account Type is required field. Account Type might be invalid.")
	private AccountType accountType;
	
	private Long accountNumber;
	private Double availableBalance;

	public AccountCreationRequestPayload(
			@NotBlank(message = "Name is required field.") @Size(max = 50, message = "Name should not exceed 50 characters.") String customerName,
			@NotBlank(message = "Mobile Number is required field.") @Size(min = 3, max = 20, message = "Mobile Number should not exceed 20 characters.") String customerMobile,
			@NotBlank(message = "Email is required field.") @Size(max = 50, message = "Email should not exceed 50 characters.") @Email String customerEmail,
			@NotBlank(message = "Address 1 is required field.") @Size(max = 100, message = "Address 1 should not exceed 100 characters.") String address1,
			@Size(max = 100, message = "Address 2 should not exceed 100 characters.") String address2,
			@NotNull(message = "Account Type is required field.") AccountType accountType, Long accountNumber, Double availableBalance) {
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.address1 = address1;
		this.address2 = address2;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.availableBalance = availableBalance;
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

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
}
