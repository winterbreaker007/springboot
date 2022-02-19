package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.time.LocalDateTime;

/**
 * Created by samgi on 04/07/2021.
 */
public class Log {
  private String type; //error, info, DATABASE
  private String userId;
  private String javaLocation;
  private String log;
  private LocalDateTime dateCreated;
  private String userDisplayName;

  public Log() { }

  public Log(String type, String javaLocation, String log) {
    this.type = type;
    this.javaLocation = javaLocation;
    this.log = log;
    this.dateCreated = LocalDateTime.now().withNano(0);
  }

  public Log(String type, String userId, String javaLocation, String log) {
    this.type = type;
    this.userId = userId;
    this.javaLocation = javaLocation;
    this.log = log;
    this.dateCreated = LocalDateTime.now().withNano(0);
  }

  public Log(String type, String userId, String javaLocation, String log,
      String userDisplayName) {
    this.type = type;
    this.userId = userId;
    this.javaLocation = javaLocation;
    this.log = log;
    this.dateCreated = LocalDateTime.now().withNano(0);
    this.userDisplayName = userDisplayName;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getJavaLocation() {
    return javaLocation;
  }

  public void setJavaLocation(String javaLocation) {
    this.javaLocation = javaLocation;
  }

  public String getLog() {
    return log;
  }

  public void setLog(String log) {
    this.log = log;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public String getUserDisplayName() {
    return userDisplayName;
  }

  public void setUserDisplayName(String userDisplayName) {
    this.userDisplayName = userDisplayName;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append(type.toUpperCase())
        .append(": ")
        .append(dateCreated)
        .append(" --")
        .append(userDisplayName)
        .append("--")
        .append(" (")
        .append(javaLocation)
        .append(") ")
        .append(log)
        .append(" >>userId: ")
        .append(userId)
        .append("<<")
        .append("\r\n")
        .toString();
  }
}
