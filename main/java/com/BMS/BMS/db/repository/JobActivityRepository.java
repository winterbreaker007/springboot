package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.JobActivity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 04/07/2021.
 */
@Repository
public interface JobActivityRepository extends JpaRepository<JobActivity, Long> {

  public List<JobActivity> findAllByParentInvoiceId(String invoiceId);

}
