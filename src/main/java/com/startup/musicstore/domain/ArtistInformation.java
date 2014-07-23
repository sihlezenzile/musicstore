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
public class ArtistInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fname;
    private String lname;

    private ArtistInformation() {
        
    }
    private ArtistInformation(Builder b) {
        id = b.id;
        lname = b.lname;
        fname = b.fname;
    }
   public static class Builder
    {
        String fname;
        String lname;
        Long id;
        
        public Builder(String f)
        {
            this.fname = f;
        }

        public Builder() {}
        public Builder lastname(String l)
        {
            lname = l;
            return this;
        }
        public Builder id(Long i)
        {
            id = i;
            return this;
        }
        public Builder name(ArtistInformation n)
        {
            lname = n.getLname();
            fname = n.getLname();
            id = n.getId();
            
            return this;
        }
        public ArtistInformation builder()
        {
            return new ArtistInformation (this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
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
        if (!(object instanceof ArtistInformation)) {
            return false;
        }
        ArtistInformation other = (ArtistInformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.ArtistInformation[ id=" + id + " ]";
    }
    
}
