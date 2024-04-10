package com.mondejar.microservices.application.service;

import com.mondejar.microservices.application.entity.Customer;

public interface ICustomerService {
	
	public Customer getCustomer();
	
	public void setCustomer(Customer customer);
}
