package com.example.BankingApplication1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingApplication1.exceptions.InavalidCredentials;
import com.example.BankingApplication1.model.Customer;
import com.example.BankingApplication1.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/registration")
	public ResponseEntity<String> customerRegistration(@RequestBody Customer customer) {
		
		Customer customer1=	customerService.customerRegistration(customer);
		
		
		 return new ResponseEntity<String>("customerId is"+" "+customer1.getCustomerId()+"   "+"customer password is"+"  "+customer1.getPassword(), HttpStatus.OK);
	}
	@GetMapping("/login")
	public ResponseEntity<String> userLogin(@RequestParam Long customerId ,@RequestParam String password) {
		Customer customer= customerService.customerLogin(customerId);
		if(password.equals(customer.getPassword()))
		{
			customer.setEnabled(true);
			customer.setCustomerId(customerId);
			
			customerService.customerRegistration(customer);
			return new ResponseEntity<String>("logged in successfully", HttpStatus.OK);
		}
		else {
			throw new InavalidCredentials();
		}	
	}
	

}
