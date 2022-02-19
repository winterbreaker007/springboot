package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.io.Serializable;

public class Contact implements Serializable{
	public Contact(String name, String role, String type, String contact) {
	
		this.name = name;
		this.role = role;
		this.type = type;
		this.contact = contact;
	}
	
	public String name;
	public String role;
	public String type;
	public String contact;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", role=" + role + ", type=" + type + ", contact=" + contact + "]";
	}
	
	
}
