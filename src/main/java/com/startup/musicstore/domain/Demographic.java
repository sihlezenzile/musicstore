/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author 211282278
 */
@Embeddable
public class Demographic implements Serializable{
    private String gender;
    private String race;
    private Date dob;

    private Demographic() {
    }
    private Demographic(Builder b) {
        gender = b.gender;
        race = b.race;
        dob = b.dob;
    }
    public static class Builder
    {
        String gender;
        String race;
        Date dob;
        
        public Builder(Date d)
        {
            this.dob =d;
        }
        public Builder race(String r)
        {
            race = r;
            return this;
        }
        public Builder gender(String g)
        {
            gender = g;
            return this;
        }
        
        public Builder demographic(Demographic d)
        {
            dob = d.getDob();
            gender = d.getGender();
            race = d.getRace();
            return this;
        }
        public Demographic builder()
        {
            return new Demographic(this);
        }
    }
    
    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public Date getDob() {
        return dob;
    }
}
