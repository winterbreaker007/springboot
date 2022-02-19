package com.blackwater.blackwaterbillingmanagementsystem.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 4/8/2021.
 */
public class ErrorResponse {

  private String error;
  private String object;

  public ErrorResponse() {}

  public ErrorResponse(String error) {
    this.error = error;
  }

  public ErrorResponse(String error, String object) {
    this.error = error;
    this.object = object;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("error", error)
        .append("object", object)
        .toString();
  }
}
