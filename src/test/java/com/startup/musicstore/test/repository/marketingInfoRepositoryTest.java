/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.MarketingInformation;
import com.startup.musicstore.respository.MarketinginfoRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
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
public class marketingInfoRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private MarketinginfoRepository repo;
    
    public marketingInfoRepositoryTest() {
    }
    @Test(enabled = true)
    public void createmarket()
    {
        repo = ctx.getBean(MarketinginfoRepository.class);
        MarketingInformation market = new MarketingInformation.Builder("Hot")
                .artist(null)
                .review(null)
                .builder();
        repo.save(market);
        
        id = market.getId();
        Assert.assertNotNull(market);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

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
