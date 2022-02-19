package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Carrier;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 12/14/2020.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

  List<Company> findAllByAccountStatusEquals(Integer accountStatus);
  List<Company> findAllById(String companyId);
  List<Company> findAllByIdIn(List<String> companyIds);
}
