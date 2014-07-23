/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.CustomerInvoice;
import com.startup.musicstore.respository.CustomerInvoiceRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author 211282278
 */
public class CustomerInvoiceRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private CustomerInvoiceRepository repo;
    
    public CustomerInvoiceRepositoryTest() {
    }
    @Test(enabled = true)
    public void createInvoice()
    {
        //Date d = new 
        repo = ctx.getBean(CustomerInvoiceRepository.class);
        
        CustomerInvoice cust = new CustomerInvoice.Builder(new java.util.Date())
                .amount(BigDecimal.ONE)

                .invoicestatus("Hello")
                .order(null)
                .builder();
        repo.save(cust);
        id = cust.getId();
        Assert.assertNotNull(cust);
                
                
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
