package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import java.util.List;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tian on 2/6/2022.
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

	Vendor findById(String id);
 }
