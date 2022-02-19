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
@Table(name = "tblAdjusters")
public class InsuranceAdjuster {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "adjuster_id")
  private String id;

  @Column(name = "adjuster_parent_carrier_id")
  private String parentCarrierId;

  @Column(name = "adjuster_first_name")
  private String firstName;

  @Column(name = "adjuster_last_name")
  private String lastName;

  @Column(name = "adjuster_display_name")
  private String displayName;

  @Column(name = "adjuster_title")
  private String title;

  @Column(name = "adjuster_address")
  private String address;

  @Column(name = "adjuster_city")
  private String city;

  @Column(name = "adjuster_state")
  private Integer state;

  @Column(name = "adjuster_zip")
  private String zip;

  @Column(name = "adjuster_work_email")
  private String workEmail;

  @Column(name = "adjuster_personal_email")
  private String personalEmail;

  @Column(name = "adjuster_work_phone")
  private BigInteger workPhone;

  @Column(name = "adjuster_work_phone_extension")
  private String workPhoneExtension;

  @Column(name = "adjuster_mobile_phone")
  private BigInteger mobilePhone;

  @Column(name = "adjuster_fax_number")
  private BigInteger faxNumber;

  @Column(name = "adjuster_notes")
  private String notes;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParentCarrierId() {
    return parentCarrierId;
  }

  public void setParentCarrierId(String parentCarrierId) {
    this.parentCarrierId = parentCarrierId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getWorkEmail() {
    return workEmail;
  }

  public void setWorkEmail(String workEmail) {
    this.workEmail = workEmail;
  }

  public String getPersonalEmail() {
    return personalEmail;
  }

  public void setPersonalEmail(String personalEmail) {
    this.personalEmail = personalEmail;
  }

  public BigInteger getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(BigInteger workPhone) {
    this.workPhone = workPhone;
  }

  public String getWorkPhoneExtension() {
    return workPhoneExtension;
  }

  public void setWorkPhoneExtension(String workPhoneExtension) {
    this.workPhoneExtension = workPhoneExtension;
  }

  public BigInteger getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(BigInteger mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public BigInteger getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(BigInteger faxNumber) {
    this.faxNumber = faxNumber;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
