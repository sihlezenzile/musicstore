/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.ArtistInformation;
import com.startup.musicstore.respository.ArtistInformationRepository;
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
public class ArtistInformationRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private ArtistInformationRepository artistrepo;
    
    public ArtistInformationRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test(enabled = true)
    public void createArtist()
    {
        artistrepo = ctx.getBean(ArtistInformationRepository.class);
        ArtistInformation artist = new ArtistInformation.Builder("Mandoza")
                .lastname("Blade")
                .builder();
        artistrepo.save(artist);
        id = artist.getId();
        Assert.assertNotNull(artist);
    }
    
    @Test(dependsOnMethods="createArtist",enabled = true)
    public void readArtist()
    {
        artistrepo = ctx.getBean(ArtistInformationRepository.class);
        ArtistInformation artist = artistrepo.findOne(id);
        Assert.assertEquals(artist.getLname(), "Blade");
    }
    @Test(dependsOnMethods="readArtist",enabled = true)
    public void updateArtist()
    {
        artistrepo = ctx.getBean(ArtistInformationRepository.class);
        ArtistInformation artist = artistrepo.findOne(id);
        ArtistInformation updated = new ArtistInformation.Builder()
                .name(artist)
                .lastname("Sword")
                .builder();
        artistrepo.save(updated);
        ArtistInformation newartist = artistrepo.findOne(id);
        Assert.assertEquals(newartist.getLname(), "Sword");        
    }
    @Test(dependsOnMethods="updateArtist",enabled = true)
    public void deleteArtist()
    {
        artistrepo = ctx.getBean(ArtistInformationRepository.class);
        ArtistInformation dele = artistrepo.findOne(id);
        artistrepo.delete(dele);
        ArtistInformation search = artistrepo.findOne(id);
        
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
