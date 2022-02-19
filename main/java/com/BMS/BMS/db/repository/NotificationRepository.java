package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Company;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Membership;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Notification;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
    List<Notification> findByCompanyId(String companyId);
    void deleteAllByCompanyId(String companyId);    
}
