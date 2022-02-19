package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Account;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountInvoices;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findById(String id);
 
}
