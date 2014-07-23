/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 211282278
 */
@Entity
public class CustomerAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String street;
    private String postal;

    private CustomerAddress() {
    }
    
    private CustomerAddress(Builder b) {
        id = b.id;
        street = b.street;
        postal = b.postal;
    }
    public static class Builder
    {
        String street;
        String postal;
        Long id;
        public Builder(String s)
        {
            this.street = s;
        }
        public Builder()
        {
            
        }
        public Builder postal(String p)
        {
            postal = p;
            return this;
        }
        public Builder id(Long i)
        {
            id = i;
            return this;
        }
        public Builder customerAddress(CustomerAddress c)
        {
            street = c.getStreet();
            postal = c.getPostal();
            id = c.getId();
            return this;
        }
        public CustomerAddress builder()
        {
            return new CustomerAddress(this);
        }
    }

    public String getStreet() {
        return street;
    }

    public String getPostal() {
        return postal;
    }
    public Long getId() {
        return id;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAddress)) {
            return false;
        }
        CustomerAddress other = (CustomerAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.CustomerAddress[ id=" + id + " ]";
    }
    
}
