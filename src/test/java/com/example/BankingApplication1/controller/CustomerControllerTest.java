package com.example.BankingApplication1.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.BankingApplication1.model.BeneficiaryAccount;
import com.example.BankingApplication1.model.Customer;
import com.example.BankingApplication1.model.SavingsAccount;
import com.example.BankingApplication1.service.CustomerService;

import junit.framework.Assert;



@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerControllerTest {

    @InjectMocks
    CustomerController customerController;
    
    @Mock
    CustomerService customerService;
    
    @Test
    public void TestSaveCustomerFotPostive() {
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
        
        beneficiaryAccount.setName("wdssc");
        beneficiaryAccount.setEmail("ssfs@gmail.com");
        beneficiaryAccount.setAccountNumber(456799L);
        beneficiaryAccount.setPhone("9876543241");
        beneficiaryAccount.setDescription("account ");
        beneficiaryAccountList.add(beneficiaryAccount);
        customer.setBeneficiaryAccountList(beneficiaryAccountList);
        Mockito.when(customerService.customerRegistration(Mockito.any(Customer.class))).thenReturn((customer));
        ResponseEntity<String> resCustomer = customerController.customerRegistration(customer);
        Assert.assertNotNull(resCustomer);
        Assert.assertEquals(customer.getLastName(),"kinthali");
    }

    @Test
    public void TestSaveCustomerForNegative() {
        Customer customer1 = new Customer();
        customer1.setCustomerId(2L);
        customer1.setFirstName("kavya");
        customer1.setLastName("kinthali");
        
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setFirstName("kavya");
        customer.setLastName("kinthali");

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setId(1L);
        savingsAccount.setAccountNumber(23453245);
        savingsAccount.setAccountBalance(64323L);
        customer.setSavingsAccount(savingsAccount);

        List<BeneficiaryAccount> beneficiaryAccountList = new ArrayList<>();
        BeneficiaryAccount beneficiaryAccount = new BeneficiaryAccount();
    
        beneficiaryAccount.setName("wdssc");
        beneficiaryAccountList.add(beneficiaryAccount);
        customer.setBeneficiaryAccountList(beneficiaryAccountList);

        Mockito.when(customerService.customerRegistration(Mockito.any(Customer.class))).thenReturn((customer1));
        ResponseEntity<String> resCustomer = customerController.customerRegistration(customer);
        Assert.assertNotNull(resCustomer);
        Assert.assertEquals(customer.getLastName(),customer1.getLastName());
    }
    
    @Test(expected =Exception.class)
    public void testSaveCustomerForExce() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setFirstName("kavya");
        customer.setLastName("kinthali");
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setId(1L);
        savingsAccount.setAccountNumber(23453245);
        customer.setSavingsAccount(savingsAccount);
        List<BeneficiaryAccount> beneficiaryAccountList = new ArrayList<>();
        BeneficiaryAccount beneficiaryAccount = new BeneficiaryAccount();
        
        beneficiaryAccount.setName("wdssc");
        beneficiaryAccountList.add(beneficiaryAccount);
        customer.setBeneficiaryAccountList(beneficiaryAccountList);
        
        Mockito.when(customerService.customerRegistration(Mockito.any(Customer.class))).thenThrow(Exception.class);
        ResponseEntity<String> resCustomer = customerController.customerRegistration(customer);
    }
    @Test
    public void TestLoginForPostive() {
        
        Customer customer = new Customer() ;        
        customer.setCustomerId(1L);
        customer.setFirstName("kavya");
        customer.setLastName("kinthali");
        customer.setEmail("kavya@gmail.com");
        customer.setPassword("kavya");
        
        Mockito.when(customerService.customerLogin(4L)).thenReturn( customer);
        ResponseEntity<String> customer2 =customerController.userLogin( 4L, "kavya");
        Assert.assertNotNull(customer2);
        Assert.assertEquals(customer.getPassword(),"kavya");
    }
    
}
 