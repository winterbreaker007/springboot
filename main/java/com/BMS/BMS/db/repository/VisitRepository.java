package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
	
	@Query("select v from Visit v where v.jobId = ?1")
	List<Visit> findVisitsByJobId(String jobId);

}
