package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 04/07/2021.
 */
@Entity
@Table(name = "tblJobActivity")
public class JobActivity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "activity_id")
  private String id;

  @JsonIgnore
  @Column(name = "job_activity_parent_job_id")
  private String parentJobId;

  @Column(name = "job_activity_saved_by")
  private String savedBy;

  @Column(name = "job_activity_last_saved_date")
  private LocalDateTime lastSavedDate;

  @Column(name = "job_activity_activity")
  private String activity;

  @Column(name = "job_activity_activity_number")
  private Double activityNumber;

  @Column(name = "job_activity_date_of_activity")
  private LocalDateTime dateOfActivity;

  @Column(name = "job_activity_carrier_amount")
  private Double carrierAmount;

  @Column(name = "job_activity_client_amount")
  private Double clientAmount;

  @Column(name = "job_activity_date_entered")
  private LocalDateTime dateEntered;

  @Column(name = "job_activity_activity_notes")
  private String activityNotes;

  @Column(name = "job_activity_entry_sequence")
  private Integer entrySequence;

  @Column(name = "job_activity_parent_invoice_id")
  private String parentInvoiceId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParentJobId() {
    return parentJobId;
  }

  public void setParentJobId(String parentJobId) {
    this.parentJobId = parentJobId;
  }

  public String getSavedBy() {
    return savedBy;
  }

  public void setSavedBy(String savedBy) {
    this.savedBy = savedBy;
  }

  public LocalDateTime getLastSavedDate() {
    return lastSavedDate;
  }

  public void setLastSavedDate(LocalDateTime lastSavedDate) {
    this.lastSavedDate = lastSavedDate;
  }

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public Double getActivityNumber() {
    return activityNumber;
  }

  public void setActivityNumber(Double activityNumber) {
    this.activityNumber = activityNumber;
  }

  public LocalDateTime getDateOfActivity() {
    return dateOfActivity;
  }

  public void setDateOfActivity(LocalDateTime dateOfActivity) {
    this.dateOfActivity = dateOfActivity;
  }

  public Double getCarrierAmount() {
    return carrierAmount;
  }

  public void setCarrierAmount(Double carrierAmount) {
    this.carrierAmount = carrierAmount;
  }

  public Double getClientAmount() {
    return clientAmount;
  }

  public void setClientAmount(Double clientAmount) {
    this.clientAmount = clientAmount;
  }

  public LocalDateTime getDateEntered() {
    return dateEntered;
  }

  public void setDateEntered(LocalDateTime dateEntered) {
    this.dateEntered = dateEntered;
  }

  public String getActivityNotes() {
    return activityNotes;
  }

  public void setActivityNotes(String activityNotes) {
    this.activityNotes = activityNotes;
  }

  public Integer getEntrySequence() {
    return entrySequence;
  }

  public void setEntrySequence(Integer entrySequence) {
    this.entrySequence = entrySequence;
  }

  public String getParentInvoiceId() {
    return parentInvoiceId;
  }

  public void setParentInvoiceId(String parentInvoiceId) {
    this.parentInvoiceId = parentInvoiceId;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("parentJobId", parentJobId)
        .append("savedBy", savedBy)
        .append("lastSavedDate", lastSavedDate)
        .append("activity", activity)
        .append("activityNumber", activityNumber)
        .append("dateOfActivity", dateOfActivity)
        .append("carrierAmount", carrierAmount)
        .append("clientAmount", clientAmount)
        .append("dateEntered", dateEntered)
        .append("activityNotes", activityNotes)
        .append("entrySequence", entrySequence)
        .append("parentInvoiceId", parentInvoiceId)
        .toString();
  }
}
