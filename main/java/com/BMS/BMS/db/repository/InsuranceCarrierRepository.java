package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.InsuranceCarrier;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 12/14/2020.
 */
@Repository
public interface InsuranceCarrierRepository extends JpaRepository<InsuranceCarrier, Long> {

}
