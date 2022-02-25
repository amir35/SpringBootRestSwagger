package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.CustomerEntity;


public interface CustomerRepo{

	List<CustomerEntity> getAllCustomer();

	CustomerEntity getCustomer(int cid);

	CustomerEntity postCustomer(CustomerEntity cust);

	CustomerEntity updateCustomer(CustomerEntity cust);

	String deleteCustomer(int parseInt);
	
		
}
