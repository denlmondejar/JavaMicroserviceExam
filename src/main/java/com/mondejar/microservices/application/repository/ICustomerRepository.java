package com.mondejar.microservices.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mondejar.microservices.application.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {}