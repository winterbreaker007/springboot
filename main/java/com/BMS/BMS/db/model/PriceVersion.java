package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 3/24/2021.
 */
@Entity
@Table(name = "tblPriceVersion")
public class PriceVersion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "price_version_id")
  private String id;

  @Column(name = "price_version_name")
  private String name;

  @Column(name = "price_version_start_date")
  private LocalDateTime startDate;

  @Column(name = "price_version_end_date")
  private LocalDateTime endDate;

  @Column(name = "price_active")
  private boolean active;

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

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("name", name)
        .append("startDate", startDate)
        .append("endDate", endDate)
        .append("active", active)
        .toString();
  }
}
