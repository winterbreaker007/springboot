package com.blackwater.blackwaterbillingmanagementsystem.model;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 3/24/2021.
 */
public class ClientWithJwt {
  String jwt;
  Client client;

  public String getJwt() {
    return jwt;
  }

  public void setJwt(String jwt) {
    this.jwt = jwt;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("jwt", jwt)
        .append("client", client)
        .toString();
  }
}
