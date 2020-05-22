package com.example.BankingApplication1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingApplication1.exceptions.InsufficientCustomerDetails;
import com.example.BankingApplication1.model.Customer;
import com.example.BankingApplication1.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer customerRegistration(Customer customer) {
		if(customer.getPassword()!=null) {
			return customerRepository.save(customer);
		}
		else {
			throw new InsufficientCustomerDetails();
		}
	}
	public Customer customerLogin(Long id) {
		return customerRepository.findById(id).get();
		}
}
	


