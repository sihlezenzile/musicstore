/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.respository.CustomerAddressRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import static com.startup.musicstore.test.repository.CreditCardRepositoryTest.ctx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 211282278
 */
public class CustomerAddressRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private CustomerAddressRepository customerCardRepository;
    public CustomerAddressRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled = true)
    public void createCustomer() {
        
        customerCardRepository = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress customer= new CustomerAddress.Builder("21 Tinker Rd")
                .postal("23 PO Box Cape City")
                .builder();
        customerCardRepository.save(customer);
        id = customer.getId();
        
        Assert.assertNotNull(customer);

    }
    @Test(dependsOnMethods = "createCustomer", enabled = true)
    public void readCustomerAddress()
    {
        customerCardRepository = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress customer = customerCardRepository.findOne(id);
        Assert.assertEquals(customer.getPostal(), "23 PO Box Cape City");
        
    }
    @Test(dependsOnMethods = "readCustomerAddress", enabled = true)
    public void updateAddress()
    {
        customerCardRepository = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress customer = customerCardRepository.findOne(id);
        CustomerAddress updated = new CustomerAddress.Builder()
                .customerAddress(customer)
                .postal("PO Box 23 Bell")                
                .builder();
        
        customerCardRepository.save(updated);
        CustomerAddress newAddress = customerCardRepository.findOne(id);
        Assert.assertEquals(newAddress.getPostal(), "PO Box 23 Bell");
        
    }
    @Test(dependsOnMethods = "updateAddress", enabled = true)
    public void deleteCustomer()
    {
        customerCardRepository = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress dele = customerCardRepository.findOne(id);
        customerCardRepository.delete(dele);
        CustomerAddress search = customerCardRepository.findOne(id);
        
        Assert.assertNull(search);
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
