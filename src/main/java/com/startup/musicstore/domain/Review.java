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
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private int rating;

    private Review() {
    }
    private Review(Builder b) {
        id = b.id;
        description = b.description;
        rating = b.rating;
    }
   public static class Builder
   {
        Long id;
        String description;
        int rating;
        
        public Builder(int r)
        {
            this.rating = r;
        }
        public Builder(){}
        public Builder id(Long i)
        {
            id = i;
            return this;
        }
        public Builder description(String d)
        {
            description = d;
            return this;
        }
        public Builder review(Review r)
        {
            id = r.getId();
            rating = r.getRating();
            description = r.getDescription();
            return this;
        }
        public Review builder()
        {
            return new Review(this);
        }
   }
    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
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
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Review[ id=" + id + " ]";
    }
    
}
