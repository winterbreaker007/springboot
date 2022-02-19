package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by samgi on 12/21/2020.
 */
@Entity
@Table(name = "tblValueListSettings")
public class ValueListSetting {

  @Id  
  @Column(name = "value_list_settings_id")
  private String id;

  @Column(name = "list_name")
  private String listName;

  @Column(name = "field_list_value")
  private String fieldListValue;

  @Column(name = "field_list_number")
  private Integer fieldListNumber;

  @Column(name = "field_list_description")
  private String fieldListDescription;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public String getFieldListValue() {
    return fieldListValue;
  }

  public void setFieldListValue(String fieldListValue) {
    this.fieldListValue = fieldListValue;
  }

  public Integer getFieldListNumber() {
    return fieldListNumber;
  }

  public void setFieldListNumber(Integer fieldListNumber) {
    this.fieldListNumber = fieldListNumber;
  }

  public String getFieldListDescription() {
    return fieldListDescription;
  }

  public void setFieldListDescription(String fieldListDescription) {
    this.fieldListDescription = fieldListDescription;
  }
}
