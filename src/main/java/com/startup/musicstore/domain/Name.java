/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author 211282278
 */
@Embeddable
public class Name implements Serializable{
    private String firstname;
    private String lastname;

    private Name() {
    }
    
    private Name(Builder b) {
        firstname = b.firstname;
        lastname = b.lastname;
    }
    public static class Builder
    {
        String firstname;
        String lastname;
        
        public Builder(String f)
        {
            this.firstname = f;
        }
        public Builder lastname(String l)
        {
            lastname = l;
            return this;
        }
        public Builder name(Name n)
        {
            lastname = n.getLastname();
            firstname = n.getFirstname();
            
            return this;
        }
        public Name builder()
        {
            return new Name (this);
        }
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    
    
}
