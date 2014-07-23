/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 211282278
 */
@Entity
public class MarketingInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;
    
    //Relationships
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "market_id")
    List<Review> review;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "market_id")
    ArtistInformation artist;

    private MarketingInformation() {
    }
    private MarketingInformation(Builder b) {
        id = b.id;
        status = b.status;
        artist = b.artist;
        review = b.review;
    }
    
    public static class Builder
    {
        Long id;
        String status;
        ArtistInformation artist;
        List<Review> review;
        
        public Builder(String s)
        {
            this.status = s;
        }
        public Builder id(Long i)
        {
            id = i;return this;
        }
        public Builder artist(ArtistInformation a)
        {
            artist = a; return this;
        }
        public Builder review(List<Review> r)
        {
            review = r; return this;            
        }
        public Builder marketing(MarketingInformation m)
        {
            status = m.getStatus();
            id = m.getId();
            review = m.getReview();
            artist = m.getArtist();
            return this;
        }
        public MarketingInformation builder()
        {
            return new MarketingInformation(this);
        }
        
    }
    public String getStatus() {
        return status;
    }

    public List<Review> getReview() {
        return review;
    }

    public ArtistInformation getArtist() {
        return artist;
    }


    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof MarketingInformation)) {
            return false;
        }
        MarketingInformation other = (MarketingInformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.MarketingInformation[ id=" + id + " ]";
    }
    
}
