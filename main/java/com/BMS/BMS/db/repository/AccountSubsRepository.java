package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountSubs;

@Repository
public interface AccountSubsRepository extends JpaRepository<AccountSubs, Long>{
	

	List<AccountSubs> findByAccountId(String accountId);
}
