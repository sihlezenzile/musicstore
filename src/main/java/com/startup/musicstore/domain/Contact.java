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
public class Contact implements Serializable{
    private String phone;
    private String cell;

    private Contact() {
    }
    private Contact(Builder b) {
        phone = b.phone;
        cell = b.cell;
    }
    public static class Builder
    {
        String phone;
        String cell;
        
        public Builder(String c)
        {
            this.cell = c;
        }
        public Builder phone(String p)
        {
            phone = p;
            return this;
        }
        public Builder contact(Contact c)
        {
            phone = c.getPhone();
            cell = c.getCell();
            
            return this;
        }
        public Contact builder()
        {
            return new Contact(this);
        }
    }
    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }
    
}
