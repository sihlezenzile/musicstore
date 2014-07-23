/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.respository;

import com.startup.musicstore.domain.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 211282278
 */
@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long>{
    
}
