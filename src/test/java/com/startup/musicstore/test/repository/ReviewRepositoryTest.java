/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.Review;
import com.startup.musicstore.respository.ReviewRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import static com.startup.musicstore.test.repository.CustomerAddressRepositoryTest.ctx;
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
public class ReviewRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private ReviewRepository revrepo;
    
    public ReviewRepositoryTest() {
    }

    @Test(enabled = true)
    public void createReview()
    {
        revrepo = ctx.getBean(ReviewRepository.class);
        Review rev = new Review.Builder(7)
                .description("Good")
                .builder();
        revrepo.save(rev);
        id = rev.getId();
        Assert.assertNotNull(rev);
    }
    @Test(dependsOnMethods = "createReview",enabled = true)
    public void readReview()
    {
        revrepo = ctx.getBean(ReviewRepository.class);
        Review rev = revrepo.findOne(id);
        
        Assert.assertEquals(rev.getRating(), 7);
    }
    @Test(dependsOnMethods = "readReview", enabled = true)
    public void updateview()
    {
        revrepo = ctx.getBean(ReviewRepository.class);
        Review rev = revrepo.findOne(id);
        Review updated = new Review.Builder()
                .review(rev)
                .description("Better")
                .builder();
        revrepo.save(updated);
         Review newreview = revrepo.findOne(id);
         Assert.assertEquals(newreview.getDescription(), "Better");        
    }
    @Test(dependsOnMethods = "updateview", enabled = true)
    public void deleteReview()
    {
        revrepo = ctx.getBean(ReviewRepository.class);
        Review rev = revrepo.findOne(id);
        revrepo.delete(rev);
        Review search = revrepo.findOne(id);
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
