package com.blackwater.blackwaterbillingmanagementsystem.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 4/8/2021.
 */
public class AuthenticationResponse {

  private final String jwt;

  public AuthenticationResponse(String jwt) {
    this.jwt = jwt;
  }

  public String getJwt() {
    return jwt;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("jwt", jwt)
        .toString();
  }
}
