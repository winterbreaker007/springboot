package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by tian on 2/6/2022.
 */
@Entity
@Table(name = "tblVendors")
public class Vendor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vendor_id")
  private String id;

  @Column(name = "vendor_parent_company_id")
  private String vendorParentCompanyId;

  @Column(name = "vendor_name")
  private String vendorName;

  @Column(name = "vendor_address")
  private String vendorAddress;

  @Column(name = "vendor_city")
  private String vendorCity;

  @Column(name = "vendor_state")
  private Integer vendorState;

  @Column(name = "vendor_zip")
  private String vendorZip;

  @Column(name = "vendor_country")
  private Integer vendorCounty;

  @Column(name = "vendor_phone")
  private BigInteger vendorPhone;

  @Column(name = "vendor_fax_number")
  private BigInteger vendorFaxNumber;

  @Column(name = "vendor_contact_first_name")
  private String vendorContactFirstName;

  @Column(name = "vendor_contact_last_name")
  private String vendorContactLastName;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getVendorParentCompanyId() {
    return vendorParentCompanyId;
  }

  public void setVendorParentCompanyId(String vendorParentCompanyId) {
    this.vendorParentCompanyId = vendorParentCompanyId;
  }

  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public String getVendorAddress() {
    return vendorAddress;
  }

  public void setVendorAddress(String vendorAddress) {
    this.vendorAddress = vendorAddress;
  }

  public String getVendorCity() {
    return vendorCity;
  }

  public void setVendorCity(String vendorCity) {
    this.vendorCity = vendorCity;
  }

  public Integer getVendorState() {
    return vendorState;
  }

  public void setVendorState(Integer vendorState) {
    this.vendorState = vendorState;
  }

  public String getVendorZip() {
    return vendorZip;
  }

  public void setVendorZip(String vendorZip) {
    this.vendorZip = vendorZip;
  }

  public Integer getVendorCountry() {
    return vendorCounty;
  }

  public void setVendorCountry(Integer vendorCounty) {
    this.vendorCounty = vendorCounty;
  }

  public BigInteger getVendorPhone() {
    return vendorPhone;
  }

  public void setVendorPhone(BigInteger vendorPhone) {
    this.vendorPhone = vendorPhone;
  }

  public BigInteger getVendorFaxNumber() {
    return vendorFaxNumber;
  }

  public void setVendorFaxNumber(BigInteger vendorFaxNumber) {
    this.vendorFaxNumber = vendorFaxNumber;
  }

  public String getVendorContactFirstName() {
    return vendorContactFirstName;
  }

  public void setVendorContactFirstName(String vendorContactFirstName) {
    this.vendorContactFirstName = vendorContactFirstName;
  }

  public String setVendorContactLastName() {
    return vendorContactLastName;
  }

  public void getVendorContactLastName(String vendorContactLastName) {
    this.vendorContactLastName = vendorContactLastName;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("vendorParentCompanyId", vendorParentCompanyId)
        .append("vendorName", vendorName)
        .append("vendorAddress", vendorAddress)
        .append("vendorCity", vendorCity)
        .append("vendorState", vendorState)
        .append("vendorZip", vendorZip)
        .append("vendorCounty", vendorCounty)
        .append("vendorPhone", vendorPhone)
        .append("vendorFaxNumber", vendorFaxNumber)
        .append("vendorContactFirstName", vendorContactFirstName)
        .append("vendorContactLastName", vendorContactLastName)
        .toString();
  }
}
