package com.blackwater.blackwaterbillingmanagementsystem.model;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 4/8/2021.
 */
public class LoginResponse {

  private User user;

  public LoginResponse() {
  }

  public LoginResponse(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("user", user)
        .toString();
  }
}
