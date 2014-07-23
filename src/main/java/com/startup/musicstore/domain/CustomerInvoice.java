/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author 211282278
 */
@Entity
public class CustomerInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date invoiceDate;
    private BigDecimal amount;
    private String invoicestatus;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CustomerInvoice_id")
    Order order;

    private CustomerInvoice() {
    }
    private CustomerInvoice(Builder b) {
        id = b.id;
        invoiceDate = b.invoiceDate;
        amount = b.amount;
        invoicestatus = b.invoicestatus;
        order = b.order;
        
    }
    public static class Builder
    {
        Long id;
        Date invoiceDate;
        BigDecimal amount;
        String invoicestatus;
        Order order;
        
        public Builder(Date d)
        {
            this.invoiceDate = d;
        }
        public Builder invoicestatus(String i)
        {
            invoicestatus = i;
            return this;
        }
        public Builder amount(BigDecimal a)
        {
            amount = a;return this;
        }
        public Builder order(Order o)
        {
            order = o; return this;
        }
        public Builder id(Long i)
        {
            id = i;
            return this;
        }
        public Builder customerInvoice(CustomerInvoice c)
        {
            id = c.getId();
            amount = c.getAmount();
            order = c.getOrder();
            invoicestatus = c.getInvoicestatus();
            invoiceDate = c.getInvoiceDate();
            return this;
        }
        public CustomerInvoice builder()
        {
            return new CustomerInvoice(this);
        }
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getInvoicestatus() {
        return invoicestatus;
    }

    public Order getOrder() {
        return order;
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
        if (!(object instanceof CustomerInvoice)) {
            return false;
        }
        CustomerInvoice other = (CustomerInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.CustomerInvoice[ id=" + id + " ]";
    }
    
}
