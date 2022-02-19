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
 * Created by samgi on 6/23/2021.
 */
@Entity
@Table(name = "tblPriceListRegions")
public class PriceListRegion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "regions_id")
  private String regionId;

  @Column(name = "price_list_region_name")
  private String regionName;

  @Column(name = "price_list_state")
  private int stateId;

  @Column(name = "price_list_materials_sales_tax")
  private double materialsSalesTax;

  @Column(name = "price_list_date_last_updated")
  private LocalDateTime dateLastUpdated;

  public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionsId) {
    this.regionId = regionsId;
  }

  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }

  public int getStateId() {
    return stateId;
  }

  public void setStateId(int stateId) {
    this.stateId = stateId;
  }

  public double getMaterialsSalesTax() {
    return materialsSalesTax;
  }

  public void setMaterialsSalesTax(double materialsSalesTax) {
    this.materialsSalesTax = materialsSalesTax;
  }

  public LocalDateTime getDateLastUpdated() {
    return dateLastUpdated;
  }

  public void setDateLastUpdated(LocalDateTime dateLastUpdated) {
    this.dateLastUpdated = dateLastUpdated;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("regionsId", regionId)
        .append("regionName", regionName)
        .append("stateId", stateId)
        .append("materialsSalesTax", materialsSalesTax)
        .append("dateLastUpdated", dateLastUpdated)
        .toString();
  }
}
