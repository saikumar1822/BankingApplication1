package com.example.BankingApplication1.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.BankingApplication1.model.BeneficiaryAccount;
import com.example.BankingApplication1.model.Customer;
import com.example.BankingApplication1.model.SavingsAccount;
import com.example.BankingApplication1.repository.CustomerRepository;
import com.example.BankingApplication1.service.CustomerService;

import junit.framework.Assert;

public class CustomerServiceTest {
	@InjectMocks

	CustomerService customerService;

	@Mock

	CustomerRepository customerRepository;

	@Test

	public void TestCustomerRegistration() {

		Customer customer = new Customer();

		customer.setCustomerId(1L);

		customer.setFirstName("kavya");

		customer.setLastName("kinthali");

		customer.setEmail("kavya@gmail.com");

		customer.setPassword("kavya");

		customer.setPanNo("323547345");

		customer.setPhone("9876543212");

		SavingsAccount savingsAccount = new SavingsAccount();

		savingsAccount.setId(1L);

		savingsAccount.setAccountNumber(23453245);

		savingsAccount.setAccountBalance(64323L);

		customer.setSavingsAccount(savingsAccount);

		List<BeneficiaryAccount> beneficiaryAccountList = new ArrayList<>();

		BeneficiaryAccount beneficiaryAccount = new BeneficiaryAccount();

		beneficiaryAccount.setId(1L);

		beneficiaryAccount.setName("wdssc");

		beneficiaryAccount.setEmail("ssfs@gmail.com");

		beneficiaryAccount.setAccountNumber("2355564534");

		beneficiaryAccount.setPhone("9876543241");

		beneficiaryAccount.setDescription("account ");

		beneficiaryAccountList.add(beneficiaryAccount);

		customer.setBeneficiaryAccountList(beneficiaryAccountList);

		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn((customer));
		Customer rescustomer = customerService.customerRegistration(customer);
		Assert.assertEquals(rescustomer.getPassword(), customer.getPassword());

	}
}
