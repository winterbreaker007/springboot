package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Invoice;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 3/24/2021.
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

  Invoice findByNumberEquals(BigInteger invoiceNumber);

  List<Invoice> findAllByParentJobId(String jobId);
  
  List<Invoice> findAllByParentJobIdIn(List<String> jobIds);
  
  @Query("select i from Invoice i")
  List<Invoice> testQuery();

}
