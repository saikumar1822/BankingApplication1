package com.example.BankingApplication1.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.BankingApplication1.model.BeneficiaryAccount;
import com.example.BankingApplication1.repository.BeneficiaryAccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class BeneficiaryAccountServiceTest {
	
	@InjectMocks
	BeneficiaryAccountService beneficiaryAccountService;
	
	@Mock
	BeneficiaryAccountRepository beneficiaryAccountRepository;
	
	
	
	@Test
	public void updateBeneficiaryAccountRepository() {
		
		BeneficiaryAccount beneficiaryAccount =new BeneficiaryAccount();
        beneficiaryAccount.setAccountBalance(45000);
        beneficiaryAccount.setAccountNumber(2426);
        beneficiaryAccount.setName("gsp");
        beneficiaryAccount.setPhone("9087654321");
        beneficiaryAccount.setEmail("gs@gmail.com");
        beneficiaryAccount.setDescription("savings account");
        beneficiaryAccountService.updateBeneficiaryAccountRepository(beneficiaryAccount);
		assertNotNull(beneficiaryAccount);
		
		
	}
	

}
