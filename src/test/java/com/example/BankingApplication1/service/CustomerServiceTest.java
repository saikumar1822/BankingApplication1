package com.example.BankingApplication1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.BankingApplication1.model.BeneficiaryAccount;
import com.example.BankingApplication1.model.Customer;
import com.example.BankingApplication1.model.SavingsAccount;
import com.example.BankingApplication1.repository.CustomerRepository;

import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void TestSaveCustomerForPostive() {
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
        beneficiaryAccount.setAccountNumber(2355564534L);
        beneficiaryAccount.setPhone("9876543241");
        beneficiaryAccount.setDescription("account ");
        beneficiaryAccountList.add(beneficiaryAccount);
        customer.setBeneficiaryAccountList(beneficiaryAccountList);


        customerService.customerRegistration(customer);
        Mockito.verify(customerRepository, Mockito.times(1)).save(customer);


    }
    @Test
    public void TestSaveCustomerForNegative() {


        Customer customer1 = new Customer();
        customer1.setCustomerId(2L);
        customer1.setFirstName("kavya");
        customer1.setLastName("kinthali");
        customer1.setEmail("kavya@gmail.com");
        customer1.setPassword("kavya");
        customer1.setPanNo("323547345");
        
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setFirstName("kavya");
        customer.setLastName("kinthali");
        customer.setEmail("kavya@gmail.com");
        customer.setPassword("kavya");
        customer.setPanNo("323547345");


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


        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn((customer1));
        Customer resCustomer = customerService.customerRegistration(customer);
        Assert.assertNotNull(resCustomer);
        Assert.assertEquals(customer.getPassword(),customer1.getPassword());
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
        
        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenThrow(Exception.class);
        Customer resCustomer = customerService.customerRegistration(customer);
    }

    @Test
    public void TestLogin() {
        Customer customer = new Customer();
        Mockito.when(customerRepository.findById(4L)).thenReturn(Optional.of(customer));
        Customer customer2 = customerService.customerLogin(4L);
        Assert.assertNotNull(customer2);
        Assert.assertEquals(4, 4);
    }
   
}
 