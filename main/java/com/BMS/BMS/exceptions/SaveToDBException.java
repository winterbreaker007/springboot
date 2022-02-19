package com.blackwater.blackwaterbillingmanagementsystem.exceptions;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import org.springframework.lang.Nullable;

/**
 * Created by samgi on 3/2/2021.
 */
public class SaveToDBException {
  public String exception;

  @Nullable
  public Client failedClient;

  @Nullable
  public Job failedJob;

  public SaveToDBException(String exception,
      @Nullable Client failedClient) {
    this.exception = exception;
    this.failedClient = failedClient;
  }

  public SaveToDBException(String exception,
      @Nullable Job failedJob) {
    this.exception = exception;
    this.failedJob = failedJob;
  }

  public SaveToDBException(String exception,
      @Nullable Client failedClient,
      @Nullable Job failedJob) {
    this.exception = exception;
    this.failedClient = failedClient;
    this.failedJob = failedJob;
  }

  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public Client getFailedClient() {
    return failedClient;
  }

  public void setFailedClient(
      Client failedClient) {
    this.failedClient = failedClient;
  }

  public Job getFailedJob() {
    return failedJob;
  }

  public void setFailedJob(Job failedJob) {
    this.failedJob = failedJob;
  }
}
