package com.blackwater.blackwaterbillingmanagementsystem.model;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Contact;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Note;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;

public class NoteRequest {
	Job job;
	User user;
	Contact contact;
	String updatednote;
	
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Note getNote() {
		return null;
	}
	public void setNote(Note note) {
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUpdatednote() {
		return updatednote;
	}
	public void setUpdatednote(String updatednote) {
		this.updatednote = updatednote;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}
