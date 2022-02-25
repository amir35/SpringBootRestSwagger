package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.CustomerEntity;
import com.example.demo.Service.CustomerRepo;
import com.example.demo.Service.CustomerRepoImpl;

@RestController
public class SpringRestController {

	@Autowired
	private CustomerRepo repo;
	
	@GetMapping("/home")
	public String getMessage()
	{
		return "Welcome to Spring Boot Rest";
	}
	
	@GetMapping("/customer")
	public List<CustomerEntity> getCustomer()
	{
		return  this.repo.getAllCustomer();
	}
	
	@GetMapping("/customer/{cid}")
	public CustomerEntity getCustomer(@PathVariable String custid)
	{
		System.out.println(custid);
		return this.repo.getCustomer(Integer.parseInt(custid));
	}
	
	//@PostMapping(path= "/customer",consumes="application/json")
	@PostMapping("/customer")
	public CustomerEntity postCustomer(@RequestBody CustomerEntity cust)
	{
		return this.repo.postCustomer(cust);
	}
	
	@PutMapping("/customer")
	public CustomerEntity updateCustomer(@RequestBody CustomerEntity cust)
	{
		return this.repo.updateCustomer(cust);
	}
	
	@DeleteMapping("/customer/{cid}") 
	public String deleteCustomer(@PathVariable String cid)
	{
		return this.repo.deleteCustomer(Integer.parseInt(cid));
	}
}
