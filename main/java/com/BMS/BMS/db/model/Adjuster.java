package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblAdjusters")

public class Adjuster {
	@Id
	@Column(name = "adjuster_id")
	private String id;
	
	@Column(name = "adjuster_display_name")
	private String adjusterName;
	
	@Column(name = "adjuster_work_email")
	private String email1;
	
	@Column(name = "adjuster_personal_email")
	private String email2;
	
	@Column(name = "adjuster_work_phone")
	private String phone1;
	
	@Column(name = "adjuster_work_phone_extension")
	private String phone2;
	
	@Column(name = "adjuster_mobile_phone")
	private String phone3;
	
	@Column(name = "adjuster_fax_number")
	private String fax;
	
	@Column(name = "adjuster_notes")
	private String notes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdjusterName() {
		return adjusterName;
	}

	public void setAdjusterName(String adjusterName) {
		this.adjusterName = adjusterName;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Adjuster [id=" + id + ", adjusterName=" + adjusterName + ", email1=" + email1 + ", email2=" + email2
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", fax=" + fax + ", notes="
				+ notes + "]";
	}
}
