package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Carrier;


@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long>{
    
  List<Carrier> findById(String Id);
//  Optional<Note> findById(String clientId);
//  List<Note> findByClientIdOrderByDateEnteredDesc(String clientId);
    
}
