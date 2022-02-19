package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 12/17/2020.
 */
@Entity
@Table(name = "tblNotifications")
public class Notification {

  @Id
  @Column(name = "notifications_id")
  private String id;

  @Column(name = "notifications_parent_company_id")
  private String companyId;

  @Column(name = "notifications_notification")
  private String notification;

  @Column(name = "notifications_notified_user")
  private String user;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String getNotification() {
		return notification;
	}
	
	public void setNotification(String notification) {
		this.notification = notification;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Notification [id=" + id + ", companyId=" + companyId + ", notification=" + notification + ", user=" + user
				+ "]";
	}

}
