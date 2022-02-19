package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblInsuranceCarriers")

public class Carrier {
	@Id
	@Column(name = "carrier_id")
	private String id;
	
	@Column(name = "carrier_name")
	private String carrierName;
	
	@Column(name = "claims_phone_1")
	private String phone1;
	
	@Column(name = "claims_phone_2")
	private String phone2;
	
	@Column(name = "claims_data_fax_1")
	private String fax1;
	
	@Column(name = "claims_data_fax_2")
	private String fax2;
	
	@Column(name = "claims_data_email_1")
	private String email1;
	
	@Column(name = "claims_data_email_2")
	private String email2;
	
	@Column(name = "carrier_notes")
	private String notes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
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

	public String getFax1() {
		return fax1;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	public String getFax2() {
		return fax2;
	}

	public void setFax2(String fax2) {
		this.fax2 = fax2;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Carrier [id=" + id + ", carrierName=" + carrierName + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", fax1=" + fax1 + ", fax2=" + fax2 + ", email1=" + email1 + ", email2=" + email2 + ", notes=" + notes
				+ "]";
	}
	
}
