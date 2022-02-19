package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.controller.JobController;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Account;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountInvoices;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountPlans;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountSubs;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.InsuranceAdjuster;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.InsuranceCarrier;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Invoice;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.PriceListRegion;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Vendor;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.PriceVersion;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.ValueListSetting;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountInvoicesRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountPlansRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountSubsRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.ClientRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.InsuranceAdjusterRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.InsuranceCarrierRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.InvoiceRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.JobRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.PriceListRegionRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.PriceVersionRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.UserRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.ValueListSettingRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.VendorRepository;
import com.blackwater.blackwaterbillingmanagementsystem.model.InitialAccountResponse;
import com.blackwater.blackwaterbillingmanagementsystem.model.InitialDataResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 12/17/2020.
 */
@Service
public class AppService {
  public AppService(JobRepository jobRepository, ClientRepository clientRepository,
			ValueListSettingRepository valueListSettingRepository,
			InsuranceCarrierRepository insuranceCarrierRepository,
			InsuranceAdjusterRepository insuranceAdjusterRepository, UserRepository userRepository,
			InvoiceRepository invoiceRepository, PriceVersionRepository priceVersionRepository, LogService logService,
			PriceListRegionRepository priceListRegionRepository, AccountRepository accountRepository,
			AccountInvoicesRepository accountInvoicesRepository, AccountPlansRepository accountPlansRepository,
			AccountSubsRepository accountSubsRepository, VendorRepository vendorRepository) {
		
		this.jobRepository = jobRepository;
		this.clientRepository = clientRepository;
		this.valueListSettingRepository = valueListSettingRepository;
		this.insuranceCarrierRepository = insuranceCarrierRepository;
		this.insuranceAdjusterRepository = insuranceAdjusterRepository;
		this.userRepository = userRepository;
		this.invoiceRepository = invoiceRepository;
		this.priceVersionRepository = priceVersionRepository;
		this.logService = logService;
		this.priceListRegionRepository = priceListRegionRepository;
		this.accountRepository = accountRepository;
		this.accountInvoicesRepository = accountInvoicesRepository;
		this.accountPlansRepository = accountPlansRepository;
		this.accountSubsRepository = accountSubsRepository;
    this.vendorRepository = vendorRepository;
	}
private static final Logger logger = LoggerFactory.getLogger(AppService.class);
  private JobRepository jobRepository;
  private ClientRepository clientRepository;
  private ValueListSettingRepository valueListSettingRepository;
  private InsuranceCarrierRepository insuranceCarrierRepository;
  private InsuranceAdjusterRepository insuranceAdjusterRepository;
  private UserRepository userRepository;
  private InvoiceRepository invoiceRepository;
  private PriceVersionRepository priceVersionRepository;
  private LogService logService;
  private PriceListRegionRepository priceListRegionRepository;

  private AccountRepository accountRepository;
  private AccountInvoicesRepository accountInvoicesRepository;
  private AccountPlansRepository accountPlansRepository;
  private AccountSubsRepository accountSubsRepository;
  private VendorRepository vendorRepository;
  
  public InitialAccountResponse getInitialAccount(String Id) {
	  try {
		  Account account=accountRepository.findById(Id);
		  List<AccountInvoices> invoices=accountInvoicesRepository.findAll();
		  List<AccountPlans> plans=accountPlansRepository.findAll();
		  List<AccountSubs> subs=accountSubsRepository.findByAccountId(Id);
		  InitialAccountResponse res=new InitialAccountResponse(account, invoices, plans, subs);
		  return res;
		    
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  return null;
  }
  public InitialDataResponse getInitialDataResponse(List<String> companyIds) {
    List<Integer> inactiveJobIds = Arrays.asList(8,9);
    List<Client> clients;
    List<Invoice> invoices;
    List<PriceVersion> priceVersions = Arrays.asList();
    List<Job> jobsWithClientsAndInvoices;
    List<ValueListSetting> valueListSettings;
    List<InsuranceCarrier> insuranceCarriers;
    List<InsuranceAdjuster> insuranceAdjusters;
    List<User> userList;
    List<PriceListRegion> priceListRegions = Arrays.asList();
    List<Vendor> vendors;

    logger.debug("Hello Koala!!!!, ", companyIds);

//    try{
//      clients = clientRepository.findAllByCompanyIds(companyIds);
//    } catch (Exception e){
//      e.printStackTrace();
//      clients = Collections.emptyList();
//      logService.errorLog("AppService.java", "Unable to get all clients by company ids: " + companyIds);
//    }
//    try{
//      invoices = invoiceRepository.findAll();
//    } catch (Exception e){
//      e.printStackTrace();
//      invoices = Collections.emptyList();
//      logService.errorLog("AppService.java", "Unable to get all invoices");
//    }
    try{
      List<Job> jobs = jobRepository.findAllByJobStatusNotInAndCompanyIdIn(inactiveJobIds, companyIds);
      //TODO: only pull non deleted jobs. do same with clients?
//      List<Job> jobs = jobRepository.findAllByJobStatusNotInAndCompanyIdInAndJobDeleted(inactiveJobIds, companyIds, false);
//      jobsWithClientsAndInvoices = jobsWithClientsAndInvoices(clients, jobs, invoices);
      
      
      jobsWithClientsAndInvoices = jobsWithClientsAndInvoices(jobs);
    } catch (Exception e){
      e.printStackTrace();
      jobsWithClientsAndInvoices = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all active jobs by company ids: " + companyIds);
    }
    try{
      valueListSettings = valueListSettingRepository.findAll();
    } catch (Exception e){
      e.printStackTrace();
      valueListSettings = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all value list settings");
    }
    try{
      insuranceCarriers = insuranceCarrierRepository.findAll();
    } catch (Exception e){
      e.printStackTrace();
      insuranceCarriers = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all insurance carriers");
    }
    try{
      insuranceAdjusters = insuranceAdjusterRepository.findAll();
    } catch (Exception e){
      e.printStackTrace();
      insuranceAdjusters = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all insurance adjusters");
    }
    try{
      userList = userRepository.findAll();
    } catch (Exception e){
      e.printStackTrace();
      userList = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all users");
    }
    try{
      priceVersions = priceVersionRepository.findAll();
    } catch (Exception e){
      e.printStackTrace();
      priceVersions = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all price versions");
    }
    try{
      priceListRegions = priceListRegionRepository.findAll();
    } catch (Exception e){
      e.printStackTrace();
      priceListRegions = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all price list regions");
    }
    try{
      vendors = vendorRepository.findAll();
    } catch (Exception e){
      e.printStackTrace();
      vendors = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all vendors");
    }
    return new InitialDataResponse(
        jobsWithClientsAndInvoices,
        valueListSettings,
        insuranceCarriers,
        insuranceAdjusters,
        userList,
        priceVersions,
        priceListRegions,
        vendors);
  }

  public List<Job> getInactiveJobsWithClients(List<String> companyIds){
    List<Integer> inactiveJobIds = Arrays.asList(8,9);
    List<Client> clients;
    List<Invoice> invoices;
    List<Job> jobs;

    try{
        jobs = jobRepository.findAllByJobStatusInAndCompanyIdIn(inactiveJobIds, companyIds);
      } catch (Exception e){
        e.printStackTrace();
        jobs = Collections.emptyList();
        logService.errorLog("AppService.java", "Unable to get all inactive jobs with inactive job ids: " + inactiveJobIds + " and company ids: " + companyIds);
      }
    
    try{
      clients = clientRepository.findAllByCompanyIds(companyIds);
    } catch (Exception e){
      e.printStackTrace();
      clients = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all inactive clients with company ids: " + companyIds);
    }
    try{
      invoices = invoiceRepository.findAll();
    } catch (Exception e){
      e.printStackTrace();
      invoices = Collections.emptyList();
      logService.errorLog("AppService.java", "Unable to get all invoices for inactive jobs");
    }

    return jobsWithClientsAndInvoices(jobs );
  }

  private List<Job> jobsWithClientsAndInvoices(List<Job> jobs){
	  ArrayList<String> clientIds=new ArrayList<String>();
	  ArrayList<String> jobIds=new ArrayList<String>();
	  
	  List<Invoice> invoices = new ArrayList<>();
	  List<Client> clients= new ArrayList<>();
	  
	  
	 
	  for (Job job : jobs) {
		  if (!clientIds.contains(job.getClientId()))
			  clientIds.add(job.getClientId());
		  if (!jobIds.contains(job.getId()))
			  jobIds.add((job.getId()));
	    }
	  
	  invoices = invoiceRepository.findAllByParentJobIdIn(jobIds);
	  clients=clientRepository.findAllByIdIn(clientIds);
	  
	  logger.debug("start jobs with clients and invoices!!!");
	  logger.debug("invoices size: "+invoices.size() );
	  logger.debug("clients size: "+clients.size());
	  
    for (Job job : jobs) {
      job.setClient(findJobClient(clients,job.getClientId()));
      job.setInvoices(findJobInvoices(invoices,job.getId()));
    }
    return jobs;
  }

  private List<Invoice> findJobInvoices(List<Invoice> invoices, String jobId){
    List<Invoice> jobInvoices = new ArrayList<>();
    for (Invoice invoice : invoices) {
      if (Objects.nonNull(invoice.getParentJobId()) && invoice.getParentJobId().equals(jobId)) {
        jobInvoices.add(invoice);
      }
    }
    return jobInvoices;
  }
  private List<Invoice> findJobInvoices(String jobId){
	    List<Invoice> jobInvoices = new ArrayList<>();
	    try {
	    	jobInvoices=invoiceRepository.findAllByParentJobId(jobId);	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }    
	    
	    return jobInvoices;
	  }
  
  private Client findJobClient(List<Client> clients, String jobClientId) {
    for (Client client : clients) {
      if (client.getId().equals(jobClientId)) {
        return client;
      }
    }
    return null;
  }
  private Client findJobClient(String jobClientId) {
	  try{
		  return clientRepository.findById(jobClientId);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	    return null;
	  }
  
}