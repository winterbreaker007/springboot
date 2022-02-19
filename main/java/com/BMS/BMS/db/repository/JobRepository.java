package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 12/14/2020.
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
  List<Job> findAllByJobStatusNotInAndCompanyIdIn(List<Integer> jobStatuses, List<String> companyIds);
  List<Job> findAllByJobStatusNotInAndCompanyIdInAndJobDeleted(List<Integer> jobStatuses, List<String> companyIds, boolean jobDeleted);
  List<Job> findAllByJobStatusInAndCompanyIdIn(List<Integer> inactiveJobIds, List<String> companyIds);
  List<Job> findAllByClientId(String clientId);
}
