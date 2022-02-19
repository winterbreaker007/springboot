package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Note;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	@Query("select task from Task task where task.user=?1")
	List<Task> findByUser(String clientId);
	
//	@Query("select a as task,b as job,c as client from Task a join Job b on b.id=a.jobId join Client c on c.id=b.clientId where a.user=?1")
	@Query("select a as task,b as job,c as client from Task a LEFT JOIN Job b on b.id=a.jobId LEFT JOIN Client c on c.id=b.clientId where a.user=?1")
	List<TaskJobClientProjection> findProjectionByUser(String clientId);
	
//	
	@Query("select a as task,b as job,c as client from Task a LEFT JOIN Job b on b.id=a.jobId LEFT JOIN Client c on c.id=b.clientId where a.companyId=?1")
	List<TaskJobClientProjection> findProjectionByCompany(String companyId);

	@Query("select a as task,b as job,c as client from Task a LEFT JOIN Job b on b.id=a.jobId LEFT JOIN Client c on c.id=b.clientId where a.companyId in ?1")
	List<TaskJobClientProjection> findProjectionByCompanyIn(List<String> companyIds);
	
//	@Query("SELECT e FROM employees e LEFT JOIN p.posts p ON p.owner_id = e.id WHERE p.owner_id IS NULL")
//	@Query("select a as task,b as job,c as client from Task a join Job b on b.id=a.jobId join Client c on c.id=b.clientId where a.id=?1")
	@Query("select a as task,b as job,c as client from Task a LEFT JOIN Job b on b.id=a.jobId LEFT JOIN Client c on c.id=b.clientId where a.id=?1")
	List<TaskJobClientProjection> findProjectionByTask(String taskId);
	
	Task findById(String Id);
}
