package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 12/14/2020.
 */
@Entity
@Table(name = "tblJobs")
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "job_id")
  private String id;

  @Column(name = "jobs_parent_client_id")
  public String clientId;

  @Column(name = "jobs_parent_company_id")
  public String companyId;

  @Transient
  public Client client;

  @Transient
  public List<Invoice> invoices;

  @Column(name = "jobs_job_name")
  private String jobName;

  @Column(name = "jobs_job_type")
  private Integer jobType;

  @Column(name = "jobs_job_status")
  private Integer jobStatus;

  @Column(name = "jobs_job_site_address")
  private String jobSiteAddress;

  @Column(name = "jobs_job_site_city")
  private String jobSiteCity;

  @Column(name = "jobs_job_site_state")
  private Integer jobSiteState;

  @Column(name = "jobs_job_site_zip")
  private String jobSiteZip;

  @Column(name = "jobs_job_site_country")
  private Integer jobSiteCountry;

  @Column(name = "jobs_job_notes")
  private String jobNotes;

  @Column(name = "jobs_occupant_first_name")
  private String occupantFirstName;

  @Column(name = "jobs_occupant_last_name")
  private String occupantLastName;

  @Column(name = "jobs_occupant_home_phone")
  private String occupantHomePhone;

  @Column(name = "jobs_occupant_work_email")
  private String occupantWorkEmail;

  @Column(name = "jobs_occupant_personal_email")
  private String occupantPersonalEmail;

  @Column(name = "jobs_occupant_work_phone")
  private BigInteger occupantWorkPhone;

  @Column(name = "jobs_occupant_mobile_phone")
  private BigInteger occupantMobilePhone;

  @Column(name = "jobs_occupant_fax_number")
  private BigInteger occupantFaxNumber;

  @Column(name = "jobs_drive_time_minutes")
  private Integer driveTimeMinutes;

  @Column(name = "jobs_work_start_date")
  private LocalDateTime workStartDate;

  @Column(name = "jobs_work_completion_date")
  private LocalDateTime workCompletionDate;

  @Column(name = "jobs_billing_agent")
  private String billingAgent;

  @Column(name = "jobs_carrier_invoiced_total_amount")
  private Double carrierInvoicedTotalAmount;

  @Column(name = "jobs_carrier_settled_total_amount")
  private Double carrierSettledTotalAmount;

  @Column(name = "jobs_carrier_issued_to_contractor_total_amount")
  private Double carrierIssuedToContractorTotalAmount;

  @Column(name = "jobs_carrier_issued_to_client_total_amount")
  private Double carrierIssuedToClientTotalAmount;

  @Column(name = "jobs_carrier_total_payment_received_by_contractor")
  private Double carrierTotalPaymentReceivedByContractor;

  @Column(name = "jobs_carrier_balance_due_to_contractor")
  private Double carrierBalanceDueToContractor;

  @Column(name = "jobs_client_invoiced_total_amount")
  private Double clientInvoicedTotalAmount;

  @Column(name = "jobs_client_deductible_due_to_contractor")
  private Double clientDeductibleDueToContractor;

  @Column(name = "jobs_client_total_payment_received_by_contractor")
  private Double clientTotalPaymentReceivedByContractor;

  @Column(name = "jobs_client_balance_due_to_contractor")
  private Double clientBalanceDueToContractor;

  @Column(name = "jobs_client_late_payment")
  private Double clientLatePayment;

  @Column(name = "jobs_class_of_water")
  private Integer classOfWater;

  @Column(name = "jobs_vendor")
  private String vendor;

  @Column(name = "jobs_bill_to")
  private Integer billTo;

  @Column(name = "jobs_bill_to_insurance_company")
  private String billToInsuranceCompany;

  @Column(name = "jobs_bill_to_adjuster")
  private String billToAdjuster;

  @Column(name = "jobs_bill_to_insurance_claim_number")
  private String billToInsuranceClaimNumber;

  @Column(name = "jobs_bag")
  private Integer bag;

  @Column(name = "jobs_dropbox_folder")
  private String dropboxFolder;

  @Column(name = "jobs_type_of_loss")
  private Integer typeOfLoss;

  @Column(name = "jobs_date_of_loss")
  private LocalDateTime dateOfLoss;

  @Column(name = "jobs_cause_loss")
  private String causeOfLoss;

  @Column(name = "jobs_region_of_loss")
  private String regionOfLoss;

  @Column(name = "jobs_saved_by")
  private String savedBy;

  @Column(name = "jobs_date_last_saved")
  private LocalDateTime dateLastSaved;

  @Column(name = "jobs_deleted")
  private boolean jobDeleted;

  @Transient
  private String objectType = "Job";

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public List<Invoice> getInvoices() {
    return invoices;
  }

  public void setInvoices(
      List<Invoice> invoices) {
    this.invoices = invoices;
  }

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public Integer getJobType() {
    return jobType;
  }

  public void setJobType(Integer jobType) {
    this.jobType = jobType;
  }

  public Integer getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(Integer jobStatus) {
    this.jobStatus = jobStatus;
  }

  public String getJobSiteAddress() {
    return jobSiteAddress;
  }

  public void setJobSiteAddress(String jobSiteAddress) {
    this.jobSiteAddress = jobSiteAddress;
  }

  public String getJobSiteCity() {
    return jobSiteCity;
  }

  public void setJobSiteCity(String jobSiteCity) {
    this.jobSiteCity = jobSiteCity;
  }

  public Integer getJobSiteState() {
    return jobSiteState;
  }

  public void setJobSiteState(Integer jobSiteState) {
    this.jobSiteState = jobSiteState;
  }

  public String getJobSiteZip() {
    return jobSiteZip;
  }

  public void setJobSiteZip(String jobSiteZip) {
    this.jobSiteZip = jobSiteZip;
  }

  public Integer getJobSiteCountry() {
    return jobSiteCountry;
  }

  public void setJobSiteCountry(Integer jobSiteCountry) {
    this.jobSiteCountry = jobSiteCountry;
  }

  public String getJobNotes() {
    return jobNotes;
  }

  public void setJobNotes(String jobNotes) {
    this.jobNotes = jobNotes;
  }

  public String getOccupantFirstName() {
    return occupantFirstName;
  }

  public void setOccupantFirstName(String occupantFirstName) {
    this.occupantFirstName = occupantFirstName;
  }

  public String getOccupantLastName() {
    return occupantLastName;
  }

  public void setOccupantLastName(String occupantLastName) {
    this.occupantLastName = occupantLastName;
  }

  public String getOccupantHomePhone() {
    return occupantHomePhone;
  }

  public void setOccupantHomePhone(String occupantHomePhone) {
    this.occupantHomePhone = occupantHomePhone;
  }

  public String getOccupantWorkEmail() {
    return occupantWorkEmail;
  }

  public void setOccupantWorkEmail(String occupantWorkEmail) {
    this.occupantWorkEmail = occupantWorkEmail;
  }

  public String getOccupantPersonalEmail() {
    return occupantPersonalEmail;
  }

  public void setOccupantPersonalEmail(String occupantPersonalEmail) {
    this.occupantPersonalEmail = occupantPersonalEmail;
  }

  public BigInteger getOccupantWorkPhone() {
    return occupantWorkPhone;
  }

  public void setOccupantWorkPhone(BigInteger occupantWorkPhone) {
    this.occupantWorkPhone = occupantWorkPhone;
  }

  public BigInteger getOccupantMobilePhone() {
    return occupantMobilePhone;
  }

  public void setOccupantMobilePhone(BigInteger occupantMobilePhone) {
    this.occupantMobilePhone = occupantMobilePhone;
  }

  public BigInteger getOccupantFaxNumber() {
    return occupantFaxNumber;
  }

  public void setOccupantFaxNumber(BigInteger occupantFaxNumber) {
    this.occupantFaxNumber = occupantFaxNumber;
  }

  public Integer getDriveTimeMinutes() {
    return driveTimeMinutes;
  }

  public void setDriveTimeMinutes(Integer driveTimeMinutes) {
    this.driveTimeMinutes = driveTimeMinutes;
  }

  public LocalDateTime getWorkStartDate() {
    return workStartDate;
  }

  public void setWorkStartDate(LocalDateTime workStartDate) {
    this.workStartDate = workStartDate;
  }

  public LocalDateTime getWorkCompletionDate() {
    return workCompletionDate;
  }

  public void setWorkCompletionDate(LocalDateTime workCompletionDate) {
    this.workCompletionDate = workCompletionDate;
  }

  public String getBillingAgent() {
    return billingAgent;
  }

  public void setBillingAgent(String billingAgent) {
    this.billingAgent = billingAgent;
  }

  public Double getCarrierInvoicedTotalAmount() {
    return carrierInvoicedTotalAmount;
  }

  public void setCarrierInvoicedTotalAmount(Double carrierInvoicedTotalAmount) {
    this.carrierInvoicedTotalAmount = carrierInvoicedTotalAmount;
  }

  public Double getCarrierSettledTotalAmount() {
    return carrierSettledTotalAmount;
  }

  public void setCarrierSettledTotalAmount(Double carrierSettledTotalAmount) {
    this.carrierSettledTotalAmount = carrierSettledTotalAmount;
  }

  public Double getCarrierIssuedToContractorTotalAmount() {
    return carrierIssuedToContractorTotalAmount;
  }

  public void setCarrierIssuedToContractorTotalAmount(Double carrierIssuedToContractorTotalAmount) {
    this.carrierIssuedToContractorTotalAmount = carrierIssuedToContractorTotalAmount;
  }

  public Double getCarrierIssuedToClientTotalAmount() {
    return carrierIssuedToClientTotalAmount;
  }

  public void setCarrierIssuedToClientTotalAmount(Double carrierIssuedToClientTotalAmount) {
    this.carrierIssuedToClientTotalAmount = carrierIssuedToClientTotalAmount;
  }

  public Double getCarrierTotalPaymentReceivedByContractor() {
    return carrierTotalPaymentReceivedByContractor;
  }

  public void setCarrierTotalPaymentReceivedByContractor(
      Double carrierTotalPaymentReceivedByContractor) {
    this.carrierTotalPaymentReceivedByContractor = carrierTotalPaymentReceivedByContractor;
  }

  public Double getCarrierBalanceDueToContractor() {
    return carrierBalanceDueToContractor;
  }

  public void setCarrierBalanceDueToContractor(Double carrierBalanceDueToContractor) {
    this.carrierBalanceDueToContractor = carrierBalanceDueToContractor;
  }

  public Double getClientInvoicedTotalAmount() {
    return clientInvoicedTotalAmount;
  }

  public void setClientInvoicedTotalAmount(Double clientInvoicedTotalAmount) {
    this.clientInvoicedTotalAmount = clientInvoicedTotalAmount;
  }

  public Double getClientDeductibleDueToContractor() {
    return clientDeductibleDueToContractor;
  }

  public void setClientDeductibleDueToContractor(Double clientDeductibleDueToContractor) {
    this.clientDeductibleDueToContractor = clientDeductibleDueToContractor;
  }

  public Double getClientTotalPaymentReceivedByContractor() {
    return clientTotalPaymentReceivedByContractor;
  }

  public void setClientTotalPaymentReceivedByContractor(
      Double clientTotalPaymentReceivedByContractor) {
    this.clientTotalPaymentReceivedByContractor = clientTotalPaymentReceivedByContractor;
  }

  public Double getClientBalanceDueToContractor() {
    return clientBalanceDueToContractor;
  }

  public void setClientBalanceDueToContractor(Double clientBalanceDueToContractor) {
    this.clientBalanceDueToContractor = clientBalanceDueToContractor;
  }

  public Double getClientLatePayment() {
    return clientLatePayment;
  }

  public void setClientLatePayment(Double clientLatePayment) {
    this.clientLatePayment = clientLatePayment;
  }

  public Integer getClassOfWater() {
    return classOfWater;
  }

  public void setClassOfWater(Integer classOfWater) {
    this.classOfWater = classOfWater;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public Integer getBillTo() {
    return billTo;
  }

  public void setBillTo(Integer billTo) {
    this.billTo = billTo;
  }

  public String getBillToInsuranceCompany() {
    return billToInsuranceCompany;
  }

  public void setBillToInsuranceCompany(String billToInsuranceCompany) {
    this.billToInsuranceCompany = billToInsuranceCompany;
  }

  public String getBillToAdjuster() {
    return billToAdjuster;
  }

  public void setBillToAdjuster(String billToAdjuster) {
    this.billToAdjuster = billToAdjuster;
  }

  public String getBillToInsuranceClaimNumber() {
    return billToInsuranceClaimNumber;
  }

  public void setBillToInsuranceClaimNumber(String billToInsuranceClaimNumber) {
    this.billToInsuranceClaimNumber = billToInsuranceClaimNumber;
  }

  public Integer getBag() {
    return bag;
  }

  public void setBag(Integer bag) {
    this.bag = bag;
  }

  public String getDropboxFolder() {
    return dropboxFolder;
  }

  public void setDropboxFolder(String dropboxFolder) {
    this.dropboxFolder = dropboxFolder;
  }

  public Integer getTypeOfLoss() {
    return typeOfLoss;
  }

  public void setTypeOfLoss(Integer typeOfLoss) {
    this.typeOfLoss = typeOfLoss;
  }

  public LocalDateTime getDateOfLoss() {
    return dateOfLoss;
  }

  public void setDateOfLoss(LocalDateTime dateOfLoss) {
    this.dateOfLoss = dateOfLoss;
  }

  public String getCauseOfLoss() {
    return causeOfLoss;
  }

  public void setCauseOfLoss(String causeOfLoss) {
    this.causeOfLoss = causeOfLoss;
  }

  public String getRegionOfLoss() {
    return regionOfLoss;
  }

  public void setRegionOfLoss(String regionOfLoss) {
    this.regionOfLoss = regionOfLoss;
  }

  public String getSavedBy() {
    return savedBy;
  }

  public void setSavedBy(String savedBy) {
    this.savedBy = savedBy;
  }

  public LocalDateTime getDateLastSaved() {
    return dateLastSaved;
  }

  public void setDateLastSaved(LocalDateTime dateLastSaved) {
    this.dateLastSaved = dateLastSaved;
  }

  public boolean isJobDeleted() {
    return jobDeleted;
  }

  public void setJobDeleted(boolean jobDeleted) {
    this.jobDeleted = jobDeleted;
  }

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public String toStringNoClientNoInvoices(){
    return new ToStringBuilder(this)
        .append("id", id)
        .append("clientId", clientId)
        .append("companyId", companyId)
        .append("jobName", jobName)
        .append("jobType", jobType)
        .append("jobStatus", jobStatus)
        .append("jobSiteAddress", jobSiteAddress)
        .append("jobSiteCity", jobSiteCity)
        .append("jobSiteState", jobSiteState)
        .append("jobSiteZip", jobSiteZip)
        .append("jobSiteCountry", jobSiteCountry)
        .append("jobNotes", jobNotes)
        .append("occupantFirstName", occupantFirstName)
        .append("occupantLastName", occupantLastName)
        .append("occupantHomePhone", occupantHomePhone)
        .append("occupantWorkEmail", occupantWorkEmail)
        .append("occupantPersonalEmail", occupantPersonalEmail)
        .append("occupantWorkPhone", occupantWorkPhone)
        .append("occupantMobilePhone", occupantMobilePhone)
        .append("occupantFaxNumber", occupantFaxNumber)
        .append("driveTimeMinutes", driveTimeMinutes)
        .append("workStartDate", workStartDate)
        .append("workCompletionDate", workCompletionDate)
        .append("billingAgent", billingAgent)
        .append("carrierInvoicedTotalAmount", carrierInvoicedTotalAmount)
        .append("carrierSettledTotalAmount", carrierSettledTotalAmount)
        .append("carrierIssuedToContractorTotalAmount", carrierIssuedToContractorTotalAmount)
        .append("carrierIssuedToClientTotalAmount", carrierIssuedToClientTotalAmount)
        .append("carrierTotalPaymentReceivedByContractor", carrierTotalPaymentReceivedByContractor)
        .append("carrierBalanceDueToContractor", carrierBalanceDueToContractor)
        .append("clientInvoicedTotalAmount", clientInvoicedTotalAmount)
        .append("clientDeductibleDueToContractor", clientDeductibleDueToContractor)
        .append("clientTotalPaymentReceivedByContractor", clientTotalPaymentReceivedByContractor)
        .append("clientBalanceDueToContractor", clientBalanceDueToContractor)
        .append("clientLatePayment", clientLatePayment)
        .append("classOfWater", classOfWater)
        .append("vendor", vendor)
        .append("billTo", billTo)
        .append("billToInsuranceCompany", billToInsuranceCompany)
        .append("billToAdjuster", billToAdjuster)
        .append("billToInsuranceClaimNumber", billToInsuranceClaimNumber)
        .append("bag", bag)
        .append("dropboxFolder", dropboxFolder)
        .append("typeOfLoss", typeOfLoss)
        .append("dateOfLoss", dateOfLoss)
        .append("causeOfLoss", causeOfLoss)
        .append("regionOfLoss", regionOfLoss)
        .append("savedBy", savedBy)
        .append("dateLastSaved", dateLastSaved)
        .append("jobDeleted", jobDeleted)
        .append("objectType", objectType)
        .toString();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("clientId", clientId)
        .append("companyId", companyId)
        .append("client", client)
        .append("invoices", invoices)
        .append("jobName", jobName)
        .append("jobType", jobType)
        .append("jobStatus", jobStatus)
        .append("jobSiteAddress", jobSiteAddress)
        .append("jobSiteCity", jobSiteCity)
        .append("jobSiteState", jobSiteState)
        .append("jobSiteZip", jobSiteZip)
        .append("jobSiteCountry", jobSiteCountry)
        .append("jobNotes", jobNotes)
        .append("occupantFirstName", occupantFirstName)
        .append("occupantLastName", occupantLastName)
        .append("occupantHomePhone", occupantHomePhone)
        .append("occupantWorkEmail", occupantWorkEmail)
        .append("occupantPersonalEmail", occupantPersonalEmail)
        .append("occupantWorkPhone", occupantWorkPhone)
        .append("occupantMobilePhone", occupantMobilePhone)
        .append("occupantFaxNumber", occupantFaxNumber)
        .append("driveTimeMinutes", driveTimeMinutes)
        .append("workStartDate", workStartDate)
        .append("workCompletionDate", workCompletionDate)
        .append("billingAgent", billingAgent)
        .append("carrierInvoicedTotalAmount", carrierInvoicedTotalAmount)
        .append("carrierSettledTotalAmount", carrierSettledTotalAmount)
        .append("carrierIssuedToContractorTotalAmount", carrierIssuedToContractorTotalAmount)
        .append("carrierIssuedToClientTotalAmount", carrierIssuedToClientTotalAmount)
        .append("carrierTotalPaymentReceivedByContractor", carrierTotalPaymentReceivedByContractor)
        .append("carrierBalanceDueToContractor", carrierBalanceDueToContractor)
        .append("clientInvoicedTotalAmount", clientInvoicedTotalAmount)
        .append("clientDeductibleDueToContractor", clientDeductibleDueToContractor)
        .append("clientTotalPaymentReceivedByContractor", clientTotalPaymentReceivedByContractor)
        .append("clientBalanceDueToContractor", clientBalanceDueToContractor)
        .append("clientLatePayment", clientLatePayment)
        .append("classOfWater", classOfWater)
        .append("vendor", vendor)
        .append("billTo", billTo)
        .append("billToInsuranceCompany", billToInsuranceCompany)
        .append("billToAdjuster", billToAdjuster)
        .append("billToInsuranceClaimNumber", billToInsuranceClaimNumber)
        .append("bag", bag)
        .append("dropboxFolder", dropboxFolder)
        .append("typeOfLoss", typeOfLoss)
        .append("dateOfLoss", dateOfLoss)
        .append("causeOfLoss", causeOfLoss)
        .append("regionOfLoss", regionOfLoss)
        .append("savedBy", savedBy)
        .append("dateLastSaved", dateLastSaved)
        .append("jobDeleted", jobDeleted)
        .append("objectType", objectType)
        .toString();
  }
}
