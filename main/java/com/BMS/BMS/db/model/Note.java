package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "tblNotes")
public class Note {

  @Id
  @Column(name = "notes_id")
  private String id;  
  
  
  @Column(name = "notes_parent_client_id")
  private String clientId;  
  
  
  
  @JsonIgnoreProperties(value = "notes")
  @ManyToOne
  @JoinColumn(name = "notes_entered_by_id") 
  public User user;
  
//  @Column(name = "notes_entered_by_id")
//  private String enteredId;
  
  @Column(name = "notes_date_entered")
  private String dateEntered;
  @Column(name = "notes_time_entered")
  private String timeEntered;
  
  
  
  @Column(name = "notes_user_group")
  private int noteGroup;
  @Column(name = "notes_contact_whoisit")
  private String contactWhoisit;
  @Column(name = "notes_contact_name")
  private String contactName;
  @Column(name = "notes_contact_type")
  private String contactType;
  @Column(name = "notes_contact_value")
  private String contactValue;
  @Column(name = "notes_notes")
  private String notes;
  @Column(name = "notes_client_display_name")
  private String displayName;
  @Column(name = "notes_job_id")
  private String jobId;
  

  public Note() {}

  public Note(String id) {
    this.id = id;
  }

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getClientId() {
	return clientId;
}

public void setClientId(String clientId) {
	this.clientId = clientId;
}



public String getDateEntered() {
	return dateEntered;
}

public void setDateEntered(String dateEntered) {
	this.dateEntered = dateEntered;
}

public String getTimeEntered() {
	return timeEntered;
}

public void setTimeEntered(String timeEntered) {
	this.timeEntered = timeEntered;
}

public int getNoteGroup() {
	return noteGroup;
}

public void setNoteGroup(int noteGroup) {
	this.noteGroup = noteGroup;
}

public String getContactWhoisit() {
	return contactWhoisit;
}

public void setContactWhoisit(String contactWhoisit) {
	this.contactWhoisit = contactWhoisit;
}

public String getContactName() {
	return contactName;
}

public void setContactName(String contactName) {
	this.contactName = contactName;
}

public String getContactType() {
	return contactType;
}

public void setContactType(String contactType) {
	this.contactType = contactType;
}

public String getContactValue() {
	return contactValue;
}

public void setContactValue(String contactValue) {
	this.contactValue = contactValue;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

public String getDisplayName() {
	return displayName;
}

public void setDisplayName(String displayName) {
	this.displayName = displayName;
}

public String getJobId() {
	return jobId;
}

public void setJobId(String jobId) {
	this.jobId = jobId;
}

@Override
public String toString() {
	return "Note [id=" + id + ", clientId=" + clientId + ", enteredUser=" + user + ", dateEntered=" + dateEntered
			+ ", timeEntered=" + timeEntered + ", noteGroup=" + noteGroup + ", contactWhoisit=" + contactWhoisit
			+ ", contactName=" + contactName + ", contactType=" + contactType + ", contactValue=" + contactValue
			+ ", notes=" + notes + ", displayName=" + displayName + ", jobId=" + jobId + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}

@Override
public int hashCode() {
	return Objects.hash(clientId, contactName, contactType, contactValue, contactWhoisit, dateEntered, displayName,
			user, id, jobId, noteGroup, notes, timeEntered);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Note other = (Note) obj;
	return Objects.equals(clientId, other.clientId) && Objects.equals(contactName, other.contactName)
			&& Objects.equals(contactType, other.contactType) && Objects.equals(contactValue, other.contactValue)
			&& Objects.equals(contactWhoisit, other.contactWhoisit) && Objects.equals(dateEntered, other.dateEntered)
			&& Objects.equals(displayName, other.displayName) && Objects.equals(user, other.user)
			&& Objects.equals(id, other.id) && Objects.equals(jobId, other.jobId) && noteGroup == other.noteGroup
			&& Objects.equals(notes, other.notes) && Objects.equals(timeEntered, other.timeEntered);
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}



}
