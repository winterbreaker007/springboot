package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
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
@Table(name = "tblClients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id")
  private String id;

  @Column(name = "client_saved_by")
  private String savedBy;

  @Column(name = "client_date_last_saved")
  private LocalDateTime dateLastSaved;

  @Column(name = "client_display_name")
  private String displayName;

  @Column(name = "client_first_name")
  private String firstName;

  @Column(name = "client_last_name")
  private String lastName;

  @Column(name = "client_ai_first_name")
  private String additionalInsuredFirstName;

  @Column(name = "client_ai_last_name")
  private String additionalInsuredLastName;

  @Column(name = "client_ai_phone")
  private BigInteger additionalInsuredPhone;

  @Column(name = "client_alternative_contact_name")
  private String alternativeContactName;

  @Column(name = "client_alternative_contact_relationship")
  private String alternativeContactRelationship;

  @Column(name = "client_alternative_contact_phone")
  private BigInteger alternativeContactPhone;

  @Column(name = "client_address")
  private String address;

  @Column(name = "client_city")
  private String city;

  @Column(name = "client_state")
  private Integer state;

  @Column(name = "client_zip")
  private String zip;

  @Column(name = "client_country")
  private Integer country;

  @Column(name = "client_dob")
  private LocalDateTime dateOfBirth;

  @Column(name = "client_work_email")
  private String workEmail;

  @Column(name = "client_personal_email")
  private String personalEmail;

  @Column(name = "client_work_phone")
  private BigInteger workPhone;

  @Column(name = "client_home_phone")
  private BigInteger homePhone;

  @Column(name = "client_mobile_phone")
  private BigInteger mobilePhone;

  @Column(name = "client_fax_number")
  private BigInteger faxNumber;

  @Column(name = "client_notes")
  private String notes;

  @Column(name = "client_date_last_exported_to_qb")
  private LocalDateTime dateLastExportedToQB;

  @Column(name = "client_date_last_imported_from_qb")
  private LocalDateTime dateLastImportedFromQB;

  @Column(name = "client_contact_log")
  private String contactLog;

  @Column(name = "client_dropbox_folder")
  private String dropboxFolder;

  @Column(name = "client_deleted")
  private boolean clientDeleted;

  @Transient
  private String objectType = "Client";

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
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

  public String getAdditionalInsuredFirstName() {
    return additionalInsuredFirstName;
  }

  public void setAdditionalInsuredFirstName(String additionalInsuredFirstName) {
    this.additionalInsuredFirstName = additionalInsuredFirstName;
  }

  public String getAdditionalInsuredLastName() {
    return additionalInsuredLastName;
  }

  public void setAdditionalInsuredLastName(String additionalInsuredLastName) {
    this.additionalInsuredLastName = additionalInsuredLastName;
  }

  public BigInteger getAdditionalInsuredPhone() {
    return additionalInsuredPhone;
  }

  public void setAdditionalInsuredPhone(BigInteger additionalInsuredPhone) {
    this.additionalInsuredPhone = additionalInsuredPhone;
  }


  public String getAlternativeContactName() {
    return alternativeContactName;
  }

  public void setAlternativeContactName(String alternativeContactName) {
    this.alternativeContactName = alternativeContactName;
  }

  public String getAlternativeContactRelationship() {
    return alternativeContactRelationship;
  }

  public void setAlternativeContactRelationship(String alternativeContactRelationship) {
    this.alternativeContactRelationship = alternativeContactRelationship;
  }

  public BigInteger getAlternativeContactPhone() {
    return alternativeContactPhone;
  }

  public void setAlternativeContactPhone(BigInteger alternativeContactPhone) {
    this.alternativeContactPhone = alternativeContactPhone;
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

  public Integer getCountry() {
    return country;
  }

  public void setCountry(Integer country) {
    this.country = country;
  }

  public LocalDateTime getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDateTime dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
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

  public BigInteger getHomePhone() {
    return homePhone;
  }

  public void setHomePhone(BigInteger homePhone) {
    this.homePhone = homePhone;
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

  public LocalDateTime getDateLastExportedToQB() {
    return dateLastExportedToQB;
  }

  public void setDateLastExportedToQB(LocalDateTime dateLastExportedToQB) {
    this.dateLastExportedToQB = dateLastExportedToQB;
  }

  public LocalDateTime getDateLastImportedFromQB() {
    return dateLastImportedFromQB;
  }

  public void setDateLastImportedFromQB(LocalDateTime dateLastImportedFromQB) {
    this.dateLastImportedFromQB = dateLastImportedFromQB;
  }

  public String getContactLog() {
    return contactLog;
  }

  public void setContactLog(String contactLog) {
    this.contactLog = contactLog;
  }

  public String getDropboxFolder() {
    return dropboxFolder;
  }

  public void setDropboxFolder(String dropboxFolder) {
    this.dropboxFolder = dropboxFolder;
  }

  public boolean isClientDeleted() {
    return clientDeleted;
  }

  public void setClientDeleted(boolean clientDeleted) {
    this.clientDeleted = clientDeleted;
  }

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public String toStringWithoutContactLogAndNotes() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("savedBy", savedBy)
        .append("dateLastSaved", dateLastSaved)
        .append("displayName", displayName)
        .append("firstName", firstName)
        .append("lastName", lastName)
        .append("additionalInsuredFirstName", additionalInsuredFirstName)
        .append("additionalInsuredLastName", additionalInsuredLastName)
        .append("additionalInsuredPhone", additionalInsuredPhone)
        .append("alternativeContactName", alternativeContactName)
        .append("alternativeContactRelationship", alternativeContactRelationship)
        .append("alternativeContactPhone", alternativeContactPhone)
        .append("address", address)
        .append("city", city)
        .append("state", state)
        .append("zip", zip)
        .append("country", country)
        .append("dateOfBirth", dateOfBirth)
        .append("workEmail", workEmail)
        .append("personalEmail", personalEmail)
        .append("workPhone", workPhone)
        .append("homePhone", homePhone)
        .append("mobilePhone", mobilePhone)
        .append("faxNumber", faxNumber)
        .append("dateLastExportedToQB", dateLastExportedToQB)
        .append("dateLastImportedFromQB", dateLastImportedFromQB)
        .append("dropboxFolder", dropboxFolder)
        .append("clientDeleted", clientDeleted)
        .append("objectType", objectType)
        .toString();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("savedBy", savedBy)
        .append("dateLastSaved", dateLastSaved)
        .append("displayName", displayName)
        .append("firstName", firstName)
        .append("lastName", lastName)
        .append("additionalInsuredFirstName", additionalInsuredFirstName)
        .append("additionalInsuredLastName", additionalInsuredLastName)
        .append("additionalInsuredPhone", additionalInsuredPhone)
        .append("alternativeContactName", alternativeContactName)
        .append("alternativeContactRelationship", alternativeContactRelationship)
        .append("alternativeContactPhone", alternativeContactPhone)
        .append("address", address)
        .append("city", city)
        .append("state", state)
        .append("zip", zip)
        .append("country", country)
        .append("dateOfBirth", dateOfBirth)
        .append("workEmail", workEmail)
        .append("personalEmail", personalEmail)
        .append("workPhone", workPhone)
        .append("homePhone", homePhone)
        .append("mobilePhone", mobilePhone)
        .append("faxNumber", faxNumber)
        .append("notes", notes)
        .append("dateLastExportedToQB", dateLastExportedToQB)
        .append("dateLastImportedFromQB", dateLastImportedFromQB)
        .append("contactLog", contactLog)
        .append("dropboxFolder", dropboxFolder)
        .append("clientDeleted", clientDeleted)
        .append("objectType", objectType)
        .toString();
  }
}
