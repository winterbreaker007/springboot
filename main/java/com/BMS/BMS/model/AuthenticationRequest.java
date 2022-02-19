package com.blackwater.blackwaterbillingmanagementsystem.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 4/8/2021.
 */
public class AuthenticationRequest {

  private String username;
  private String password;

  public AuthenticationRequest() { }

  public AuthenticationRequest(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("username", username)
        .append("password", password)
        .toString();
  }
}
