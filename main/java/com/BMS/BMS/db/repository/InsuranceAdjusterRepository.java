package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.InsuranceAdjuster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 12/14/2020.
 */
@Repository
public interface InsuranceAdjusterRepository extends JpaRepository<InsuranceAdjuster, Long> {

}
