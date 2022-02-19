package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 12/14/2020.
 */
@Entity
//@Table(name = "tblUsers")
@Table(name="tblUsers",uniqueConstraints=@UniqueConstraint(columnNames={"user_system_email_address"}))

public class User {

  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private String id;

  @JsonIgnoreProperties(value = "user")
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  List<Membership> memberships;
  
  
//  @JsonIgnoreProperties(value = "user", allowSetters = true)
//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  List<Note> notes;
  

  @Column(name = "Token")
  private String token;

  @Column(name = "user_first_name")
  private String firstName;

  @Column(name = "user_last_name")
  private String lastName;

  @Column(name = "user_display_name")
  private String displayName;

  @Column(name = "user_username")
  private String username;

  @JsonIgnore
  @Column(name = "user_password", nullable = false,insertable=false,updatable=false)
  private String password;

  @Column(name = "user_role")
  private Integer role;

  @Column(name = "user_work_phone")
  private String workPhone;

  @Column(name = "user_work_phone_extension")
  private String workPhoneExtension;

  @Column(name = "user_mobile_phone")
  private String mobilePhone;

  @Column(name = "user_system_email_address", unique=true)
  private String systemEmailAddress;

  @JsonIgnore
  @Column(name = "user_system_email_password")
  private String systemEmailPassword;

  @Column(name = "user_title")
  private String title;

  @Column(name = "user_access_level")
  private Integer accessLevel;

  @Column(name = "user_computer_name")
  private String computerName;

  @Column(name = "user_billing_data_path")
  private String billingDataPath;

  @Column(name = "user_signature_base64")
  private String signatureBase64;

  @Column(name = "user_signature")
  private String signature;

  @Column(name = "user_is_contact")
  private Boolean contact;

  @JoinColumn(name = "user_parent_account_id", referencedColumnName = "account_id")
  @ManyToOne
  private TblAccounts userParentAccountId;
  
  @Column(name = "user_notes")
  private String userNotes;
  
  @Column(name = "user_address")
  private String userAddress;

  @Column(name = "user_city")
  private String userCity;

  @Column(name = "user_state")
  private Integer userState;
  
  @Column(name = "user_zip")
  private String userZip;
  
  @Column(name = "user_is_active")
  private String active;
  
  
  public User() {}

  public User(String id) {
    this.id = id;
  }

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

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public String getWorkPhoneExtension() {
    return workPhoneExtension;
  }

  public void setWorkPhoneExtension(String workPhoneExtension) {
    this.workPhoneExtension = workPhoneExtension;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public String getSystemEmailAddress() {
    return systemEmailAddress;
  }

  public void setSystemEmailAddress(String systemEmailAddress) {
    this.systemEmailAddress = systemEmailAddress;
  }

  public String getSystemEmailPassword() {
    return systemEmailPassword;
  }

  public void setSystemEmailPassword(String systemEmailPassword) {
    this.systemEmailPassword = systemEmailPassword;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getAccessLevel() {
    return accessLevel;
  }

  public void setAccessLevel(Integer accessLevel) {
    this.accessLevel = accessLevel;
  }

  public String getComputerName() {
    return computerName;
  }

  public void setComputerName(String computerName) {
    this.computerName = computerName;
  }

  public String getBillingDataPath() {
    return billingDataPath;
  }

  public void setBillingDataPath(String billingDataPath) {
    this.billingDataPath = billingDataPath;
  }

  public String getSignatureBase64() {
    return signatureBase64;
  }

  public void setSignatureBase64(String signatureBase64) {
    this.signatureBase64 = signatureBase64;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public Boolean getContact() {
    return contact;
  }

  public void setContact(Boolean contact) {
    this.contact = contact;
  }
  
  public String getActive() {
    return active;
  }

  public void seActive(String active) {
	  this.active = active;
  }

  public TblAccounts getUserParentAccountId() {
    return userParentAccountId;
  }

  public void setUserParentAccountId(TblAccounts userParentAccountId) {
    this.userParentAccountId = userParentAccountId;
  }

  public String getUserNotes() {
    return userNotes;
  }

  public void setUserNotes(String userNotes) {
    this.userNotes = userNotes;
  }
  
  public String getUserAddress() {
	return userAddress;
  }
	
  public void setUserAddress(String userAddress) {
	  this.userAddress = userAddress;
  }

  public String getUserCity() {
	  return userCity;
  }
	
  public void setUserCity(String userCity) {
	  this.userCity = userCity;
  }
	
  public Integer getUserState() {
	  return userState;
  }
	
  public void setUserState(Integer userState) {
	  this.userState = userState;
  }
  
  public String getUserZip() {
	  return userZip;
  }
	
  public void setUserZip(String userZip) {
	  this.userZip= userZip;
  }

@Override
public int hashCode() {
	return Objects.hash(accessLevel, billingDataPath, computerName, displayName, firstName, id, active, contact,
			lastName, memberships, mobilePhone, password, role, signature, signatureBase64, systemEmailAddress,
			systemEmailPassword, title, token, userAddress, userCity, userNotes, userParentAccountId, userState,
			userZip, username, workPhone, workPhoneExtension);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(accessLevel, other.accessLevel) && Objects.equals(billingDataPath, other.billingDataPath)
			&& Objects.equals(computerName, other.computerName) && Objects.equals(displayName, other.displayName)
			&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
			&& Objects.equals(active, other.active) && Objects.equals(contact, other.contact)
			&& Objects.equals(lastName, other.lastName) && Objects.equals(memberships, other.memberships)
			&& Objects.equals(mobilePhone, other.mobilePhone) && Objects.equals(password, other.password)
			&& Objects.equals(role, other.role) && Objects.equals(signature, other.signature)
			&& Objects.equals(signatureBase64, other.signatureBase64)
			&& Objects.equals(systemEmailAddress, other.systemEmailAddress)
			&& Objects.equals(systemEmailPassword, other.systemEmailPassword) && Objects.equals(title, other.title)
			&& Objects.equals(token, other.token) && Objects.equals(userAddress, other.userAddress)
			&& Objects.equals(userCity, other.userCity) && Objects.equals(userNotes, other.userNotes)
			&& Objects.equals(userParentAccountId, other.userParentAccountId)
			&& Objects.equals(userState, other.userState) && Objects.equals(userZip, other.userZip)
			&& Objects.equals(username, other.username) && Objects.equals(workPhone, other.workPhone)
			&& Objects.equals(workPhoneExtension, other.workPhoneExtension);
}

@Override
public String toString() {
	return "User [id=" + id + ", memberships=" + memberships + ", token=" + token + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", displayName=" + displayName + ", username=" + username + ", password="
			+ password + ", role=" + role + ", workPhone=" + workPhone + ", workPhoneExtension=" + workPhoneExtension
			+ ", mobilePhone=" + mobilePhone + ", systemEmailAddress=" + systemEmailAddress + ", systemEmailPassword="
			+ systemEmailPassword + ", title=" + title + ", accessLevel=" + accessLevel + ", computerName="
			+ computerName + ", billingDataPath=" + billingDataPath + ", signatureBase64=" + signatureBase64
			+ ", signature=" + signature + ", contact=" + contact + ", userParentAccountId=" + userParentAccountId
			+ ", userNotes=" + userNotes + ", userAddress=" + userAddress + ", userCity=" + userCity + ", userState="
			+ userState + ", userZip=" + userZip + ", active=" + active + "]";
}

}
