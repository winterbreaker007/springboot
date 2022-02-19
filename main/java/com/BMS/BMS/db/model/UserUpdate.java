package com.blackwater.blackwaterbillingmanagementsystem.db.model;

/**
 * Created by samgi on 6/5/2021.
 */
public class UserUpdate {

  User user;
  String updatedPassword;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getUpdatedPassword() {
    return updatedPassword;
  }

  public void setUpdatedPassword(String updatedPassword) {
    this.updatedPassword = updatedPassword;
  }
}
