package com.blackwater.blackwaterbillingmanagementsystem.model;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 3/24/2021.
 */
public class JobWithJwt {
  String jwt;
  Job job;

  public String getJwt() {
    return jwt;
  }

  public void setJwt(String jwt) {
    this.jwt = jwt;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("jwt", jwt)
        .append("job", job)
        .toString();
  }
}
