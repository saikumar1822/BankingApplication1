package com.example.BankingApplication1.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.example.BankingApplication1.model.BeneficiaryAccount;
import com.example.BankingApplication1.model.SavingsAccount;
import com.example.BankingApplication1.service.SavingsService;



@RunWith(MockitoJUnitRunner.Silent.class)
public class SavingsControllerTest {
   
	@InjectMocks
    SavingsController savingsController;

    @Mock
    SavingsService savingsService;
    
    @Test
    public void testTransfer() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setId(2L);
        savingsAccount.setAccountNumber(5465);
        savingsAccount.setAccountBalance(50000);
        
        BeneficiaryAccount beneficiaryAccount =new BeneficiaryAccount();
        beneficiaryAccount.setAccountBalance(45000);
        beneficiaryAccount.setAccountNumber(2426);
        beneficiaryAccount.setName("gsp");
        beneficiaryAccount.setPhone("9087654321");
        beneficiaryAccount.setEmail("gs@gmail.com");
        beneficiaryAccount.setDescription("savings account");
        ResponseEntity<String> savings =savingsController.transfer(savingsAccount.getId(), beneficiaryAccount.getAccountNumber(), 45000);
        assertNotNull(savings);
    }

}
 