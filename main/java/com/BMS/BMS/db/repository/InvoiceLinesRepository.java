package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.InvoiceLines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 3/24/2021.
 */
@Repository
public interface InvoiceLinesRepository extends JpaRepository<InvoiceLines, Long> {

}
