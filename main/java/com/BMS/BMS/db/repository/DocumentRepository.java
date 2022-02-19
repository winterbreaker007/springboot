package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Document;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	@Query("select d from Document d where d.parentId = ?1 AND d.type = 4")
	List<Document> findFormsByCompanyId(String companyId);

	void deleteAllByParentId(String parentId);
	
	
	@Query("select d from Document d where d.id = ?1")
	Document findById(String id);
	
	@Query("select d from Document d where d.parentId = ?1 AND d.type = 1")
	List<Document> findDocumentsByJobId(String jobId);

	@Query("select d from Document d join Visit v on v.id = d.parentId where v.jobId = ?1 AND d.type = 2")
	List<Document> findImagesByJobId(String jobId);
	
	@Query("select d from Document d where d.parentId = ?1 AND d.type = 3")
	List<Document> findSketchesByJobId(String jobId);

	

	@Query("select d from Document d where d.parentId = ?1 AND d.type = 5")
	List<Document> findReportsByClientId(String clientId);
	
	
	

}
