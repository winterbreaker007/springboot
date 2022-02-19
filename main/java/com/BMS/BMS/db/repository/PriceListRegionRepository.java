package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.PriceListRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 3/24/2021.
 */
@Repository
public interface PriceListRegionRepository extends JpaRepository<PriceListRegion, Long> {
  PriceListRegion findByRegionId(String regionId);
}
