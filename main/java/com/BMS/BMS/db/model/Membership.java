package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 12/17/2020.
 */
@Entity
@Table(name = "tblMemberships")
public class Membership {

  @Id
  @Column(name = "membership_id")
  String id;

  @JsonIgnoreProperties(value = "memberships")
  @ManyToOne
  @JoinColumn(name = "membership_child_user_id")
  public User user;

  @JsonIgnoreProperties(value = "memberships")
  @ManyToOne
//  @ManyToOne(cascade = CascadeType.ALL)  
  @JoinColumn(name = "membership_parent_company_id")
  public Company company;

  @Column(name = "membership_access_level")
  private Integer accessLevel;

  @Column(name = "membership_receive_junk_mail")
  private Integer receiveJunkMail;

  @Column(name = "membership_role")
  private String role;

  public Membership(){

  }

  public Membership(String id,
      User user, Company company, Integer accessLevel, Integer receiveJunkMail,
      String role) {
    this.id = id;
    this.user = user;
    this.company = company;
    this.accessLevel = accessLevel;
    this.receiveJunkMail = receiveJunkMail;
    this.role = role;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Integer getAccessLevel() {
    return accessLevel;
  }

  public void setAccessLevel(Integer accessLevel) {
    this.accessLevel = accessLevel;
  }

  public Integer getReceiveJunkMail() {
    return receiveJunkMail;
  }

  public void setReceiveJunkMail(Integer receiveJunkMail) {
    this.receiveJunkMail = receiveJunkMail;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("user", user)
        .append("company", company)
        .append("accessLevel", accessLevel)
        .append("receiveJunkMail", receiveJunkMail)
        .append("role", role)
        .toString();
  }
}
