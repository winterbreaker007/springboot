package com.blackwater.blackwaterbillingmanagementsystem.model;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.InsuranceAdjuster;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.InsuranceCarrier;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.PriceListRegion;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Vendor;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.PriceVersion;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.ValueListSetting;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 12/17/2020.
 */
public class InitialDataResponse {
  List<Client> clientList;
  List<Job> jobList;
  List<ValueListSetting> valueListSettings;
  List<InsuranceCarrier> insuranceCarriers;
  List<InsuranceAdjuster> insuranceAdjusters;
  List<User> userList;
  List<PriceVersion> priceVersions;
  List<PriceListRegion> priceListRegions;
  List<Vendor> vendors;

  public InitialDataResponse(){}

  public InitialDataResponse(
      List<Job> jobList,
      List<ValueListSetting> valueListSettings,
      List<InsuranceCarrier> insuranceCarriers,
      List<InsuranceAdjuster> insuranceAdjusters,
      List<User> userList,
      List<PriceVersion> priceVersions,
      List<PriceListRegion> priceListRegions,
      List<Vendor> vendors) {
    this.jobList = jobList;
    this.valueListSettings = valueListSettings;
    this.insuranceCarriers = insuranceCarriers;
    this.insuranceAdjusters = insuranceAdjusters;
    this.userList = userList;
    this.priceVersions = priceVersions;
    this.priceListRegions = priceListRegions;
    this.vendors = vendors;
  }

  public List<Client> getClientList() {
    return clientList;
  }

  public void setClientList(
      List<Client> clientList) {
    this.clientList = clientList;
  }

  public List<Job> getJobList() {
    return jobList;
  }

  public void setJobList(
      List<Job> jobList) {
    this.jobList = jobList;
  }

  public List<ValueListSetting> getValueListSettings() {
    return valueListSettings;
  }

  public void setValueListSettings(
      List<ValueListSetting> valueListSettings) {
    this.valueListSettings = valueListSettings;
  }

  public List<InsuranceCarrier> getInsuranceCarriers() {
    return insuranceCarriers;
  }

  public void setInsuranceCarriers(
      List<InsuranceCarrier> insuranceCarriers) {
    this.insuranceCarriers = insuranceCarriers;
  }

  public List<InsuranceAdjuster> getInsuranceAdjusters() {
    return insuranceAdjusters;
  }

  public void setInsuranceAdjusters(
      List<InsuranceAdjuster> insuranceAdjusters) {
    this.insuranceAdjusters = insuranceAdjusters;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(
      List<User> userList) {
    this.userList = userList;
  }

  public List<PriceVersion> getPriceVersions() {
    return priceVersions;
  }

  public void setPriceVersions(
      List<PriceVersion> priceVersions) {
    this.priceVersions = priceVersions;
  }

  public List<PriceListRegion> getPriceListRegions() {
    return priceListRegions;
  }

  public void setPriceListRegions(
      List<PriceListRegion> priceListRegions) {
    this.priceListRegions = priceListRegions;
  }

  public List<Vendor> getVendors() {
    return vendors;
  }

  public void setVendors(
      List<Vendor> vendors) {
    this.vendors = vendors;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("clientList", clientList)
        .append("jobList", jobList)
        .append("valueListSettings", valueListSettings)
        .append("insuranceCarriers", insuranceCarriers)
        .append("insuranceAdjusters", insuranceAdjusters)
        .append("userList", userList)
        .append("priceVersions", priceVersions)
        .append("priceListRegions", priceListRegions)
        .append("vendors", vendors)
        .toString();
  }
}