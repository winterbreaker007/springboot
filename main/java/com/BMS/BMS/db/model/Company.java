package com.blackwater.blackwaterbillingmanagementsystem.db.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.lang.Nullable;
/**
 * Created by samgi on 12/17/2020.
 */
@Entity
@Table(name = "tblCompanies")
public class Company {
  @Id  
  @Column(name = "company_id")	
  private String id;
  
  @JsonIgnoreProperties(value = "company")
//  @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
  @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  List<Membership> memberships;
  
  
  
  
  @Column(name = "company_name")
  private String name;
  @Column(name = "mailing_address")
  private String mailingAddress;
  @Column(name = "mailing_city")
  private String mailingCity;
  @Column(name = "mailing_state")
  private Integer mailingState;
  @Column(name = "mailing_zip")
  private String mailingZip;
  @Column(name = "mailing_country")
  private Integer mailingCountry;
  @Column(name = "office_address")
  private String officeAddress;
  @Column(name = "office_city")
  private String officeCity;
  @Column(name = "office_state")
  private Integer officeState;
  @Column(name = "office_zip")
  private String officeZip;
  @Column(name = "office_country")
  private Integer officeCountry;
  @Column(name = "company_web_site")
  private String webSite;
  @Column(name = "company_logo")
  private String logo;
  @Column(name = "company_taxid")
  private String taxid;
  @Column(name = "company_fax_number")
  private BigInteger faxNumber;
  @Column(name = "company_main_phone")
  private BigInteger mainPhone;
  @Column(name = "dropbox_folder_name")
  private String dropboxFolderName;
  @Column(name = "company_notes")
  private String notes;
  @Column(name = "billing_rate")
  private Double billingRate;
  @Column(name = "account_status")
  private Integer accountStatus;
  @Column(name = "target_abatement_amount")
  private Double targetAbatementAmount;
  @Column(name = "target_mitigation_amount")
  private Double targetMitigationAmount;
  @Column(name = "monthly_late_fee")
  private Double monthlyLateFee;
  @Column(name = "company_w9")
  private String companyW9;
  @Column(name = "lien_days")
  private Integer lienDays;
  @Column(name = "lien_days_start_trigger")
  private Integer lienDaysStartTrigger;
  @Column(name = "lien_enforce_days")
  private Integer lienEnforceDays;
  @Column(name = "lien_prelien_requirement")
  private Integer lienPrelienRequirment;
  @Column(name = "company_logo_base64")
  private String logoBase64;
  @Column(name = "company_parent_account_id")
  private Integer companyParentAccountId;
  
  @Transient
  public List<Document> forms;
  
  @Transient
  public List<Notification> notifications;
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public List<Membership> getMemberships() {
    return memberships;
  }
  public void setMemberships(
      List<Membership> memberships) {
    this.memberships = memberships;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getMailingAddress() {
    return mailingAddress;
  }
  public void setMailingAddress(String mailingAddress) {
    this.mailingAddress = mailingAddress;
  }
  public String getMailingCity() {
    return mailingCity;
  }
  public void setMailingCity(String mailingCity) {
    this.mailingCity = mailingCity;
  }
  public Integer getMailingState() {
    return mailingState;
  }
  public void setMailingState(Integer mailingState) {
    this.mailingState = mailingState;
  }
  public String getMailingZip() {
    return mailingZip;
  }
  public void setMailingZip(String mailingZip) {
    this.mailingZip = mailingZip;
  }
  public Integer getMailingCountry() {
    return mailingCountry;
  }
  public void setMailingCountry(Integer mailingCountry) {
    this.mailingCountry = mailingCountry;
  }
  public String getOfficeAddress() {
    return officeAddress;
  }
  public void setOfficeAddress(String officeAddress) {
    this.officeAddress = officeAddress;
  }
  public String getOfficeCity() {
    return officeCity;
  }
  public void setOfficeCity(String officeCity) {
    this.officeCity = officeCity;
  }
  public Integer getOfficeState() {
    return officeState;
  }
  public void setOfficeState(Integer officeState) {
    this.officeState = officeState;
  }
  public String getOfficeZip() {
    return officeZip;
  }
  public void setOfficeZip(String officeZip) {
    this.officeZip = officeZip;
  }
  public Integer getOfficeCountry() {
    return officeCountry;
  }
  public void setOfficeCountry(Integer officeCountry) {
    this.officeCountry = officeCountry;
  }
  public String getWebSite() {
    return webSite;
  }
  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }
  public String getLogo() {
    return logo;
  }
  public void setLogo(String logo) {
    this.logo = logo;
  }
  public String getTaxid() {
    return taxid;
  }
  public void setTaxid(String taxid) {
    this.taxid = taxid;
  }
  public BigInteger getFaxNumber() {
    return faxNumber;
  }
  public void setFaxNumber(BigInteger faxNumber) {
    this.faxNumber = faxNumber;
  }
  public BigInteger getMainPhone() {
    return mainPhone;
  }
  public void setMainPhone(BigInteger mainPhone) {
    this.mainPhone = mainPhone;
  }
  public String getDropboxFolderName() {
    return dropboxFolderName;
  }
  public void setDropboxFolderName(String dropboxFolderName) {
    this.dropboxFolderName = dropboxFolderName;
  }
  public String getNotes() {
    return notes;
  }
  public void setNotes(String notes) {
    this.notes = notes;
  }
  public Double getBillingRate() {
    return billingRate;
  }
  public void setBillingRate(Double billingRate) {
    this.billingRate = billingRate;
  }
  public Integer getAccountStatus() {
    return accountStatus;
  }
  public void setAccountStatus(Integer accountStatus) {
    this.accountStatus = accountStatus;
  }
  public Double getTargetAbatementAmount() {
    return targetAbatementAmount;
  }
  public void setTargetAbatementAmount(Double targetAbatementAmount) {
    this.targetAbatementAmount = targetAbatementAmount;
  }
  public Double getTargetMitigationAmount() {
    return targetMitigationAmount;
  }
  public void setTargetMitigationAmount(Double targetMitigationAmount) {
    this.targetMitigationAmount = targetMitigationAmount;
  }
  public Double getMonthlyLateFee() {
    return monthlyLateFee;
  }
  public void setMonthlyLateFee(Double monthlyLateFee) {
    this.monthlyLateFee = monthlyLateFee;
  }
  public String getCompanyW9() {
    return companyW9;
  }
  public void setCompanyW9(String companyW9) {
    this.companyW9 = companyW9;
  }
  public Integer getLienDays() {
    return lienDays;
  }
  public void setLienDays(Integer lienDays) {
    this.lienDays = lienDays;
  }
  public Integer getLienDaysStartTrigger() {
    return lienDaysStartTrigger;
  }
  public void setLienDaysStartTrigger(Integer lienDaysStartTrigger) {
    this.lienDaysStartTrigger = lienDaysStartTrigger;
  }
  public Integer getLienEnforceDays() {
    return lienEnforceDays;
  }
  public void setLienEnforceDays(Integer lienEnforceDays) {
    this.lienEnforceDays = lienEnforceDays;
  }
  public Integer getLienPrelienRequirment() {
    return lienPrelienRequirment;
  }
  public void setLienPrelienRequirment(Integer lienPrelienRequirment) {
    this.lienPrelienRequirment = lienPrelienRequirment;
  }
  public String getLogoBase64() {
    return logoBase64;
  }
  public void setLogoBase64(String logoBase64) {
    this.logoBase64 = logoBase64;
  }
  public Integer getCompanyParentAccountId() {
    return companyParentAccountId;
  }
  public void setCompanyParentAccountId(Integer companyParentAccountId) {
    this.companyParentAccountId = companyParentAccountId;
  }
	public List<Document> getForms() {
		return forms;
	}
	public void setForms(List<Document> forms) {
		this.forms = forms;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
}