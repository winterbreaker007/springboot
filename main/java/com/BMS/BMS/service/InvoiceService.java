package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.InsuranceAdjuster;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.InsuranceCarrier;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Invoice;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.ValueListSetting;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.ClientRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.InsuranceAdjusterRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.InsuranceCarrierRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.InvoiceRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.JobRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.UserRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.ValueListSettingRepository;
import com.blackwater.blackwaterbillingmanagementsystem.model.InitialDataResponse;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 12/17/2020.
 */
@Service
public class InvoiceService {
  private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

  private InvoiceRepository invoiceRepository;

  public InvoiceService(
      InvoiceRepository invoiceRepository) {
    this.invoiceRepository = invoiceRepository;
  }

  public Invoice getInvoiceByInvoiceNumber(Integer invoiceNumber){
    return invoiceRepository.findByNumberEquals(BigInteger.valueOf(invoiceNumber));
  }

  public List<Invoice> getInvoicesByJobId(String jobId){
    return invoiceRepository.findAllByParentJobId(jobId);
  }

  public Invoice test(){
   return invoiceRepository.testQuery().get(0);
  }
}
