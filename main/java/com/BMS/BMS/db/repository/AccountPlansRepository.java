package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountInvoices;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountPlans;

@Repository
public interface AccountPlansRepository extends JpaRepository<AccountPlans, Long>{

}
