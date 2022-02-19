package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by samgi on 12/21/2020.
 */
@Entity
@Table(name = "tblInsuranceCarriers")
public class InsuranceCarrier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "carrier_id")
  private String id;

  @Column(name = "carrier_name")
  private String name;

  @Column(name = "claims_phone_1")
  private BigInteger claimsPhone1;

  @Column(name = "claims_phone_2")
  private BigInteger claimsPhone2;

  @Column(name = "claims_data_fax_1")
  private BigInteger claimsDataFax1;

  @Column(name = "claims_data_fax_2")
  private BigInteger claimsDataFax2;

  @Column(name = "claims_data_email_1")
  private String claimsDataEmail1;

  @Column(name = "claims_data_email_2")
  private String claimsDataEmail2;

  @Column(name = "carrier_notes")
  private String notes;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigInteger getClaimsPhone1() {
    return claimsPhone1;
  }

  public void setClaimsPhone1(BigInteger claimsPhone1) {
    this.claimsPhone1 = claimsPhone1;
  }

  public BigInteger getClaimsPhone2() {
    return claimsPhone2;
  }

  public void setClaimsPhone2(BigInteger claimsPhone2) {
    this.claimsPhone2 = claimsPhone2;
  }

  public BigInteger getClaimsDataFax1() {
    return claimsDataFax1;
  }

  public void setClaimsDataFax1(BigInteger claimsDataFax1) {
    this.claimsDataFax1 = claimsDataFax1;
  }

  public BigInteger getClaimsDataFax2() {
    return claimsDataFax2;
  }

  public void setClaimsDataFax2(BigInteger claimsDataFax2) {
    this.claimsDataFax2 = claimsDataFax2;
  }

  public String getClaimsDataEmail1() {
    return claimsDataEmail1;
  }

  public void setClaimsDataEmail1(String claimsDataEmail1) {
    this.claimsDataEmail1 = claimsDataEmail1;
  }

  public String getClaimsDataEmail2() {
    return claimsDataEmail2;
  }

  public void setClaimsDataEmail2(String claimsDataEmail2) {
    this.claimsDataEmail2 = claimsDataEmail2;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
