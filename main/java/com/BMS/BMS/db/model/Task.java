package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblTasks")
public class Task {
	@Id
    @Column(name = "task_id")
      private String id;
	@Column(name = "task_note")
	  private String note;  
	@Column(name = "task_user_assigned")	
	  private String user;
	@Column(name = "task_role_assigned")
	  private String role;
	@Column(name = "task_due_date")
	  private String dueDate;
	@Column(name = "task_done_date")
	  private String doneDate;
	@Column(name = "task_parent_company_id")
	  private String companyId;
	@Column(name = "task_assigned_date")
	  private String assignedDate;
	@Column(name = "task_parent_job_id")
	  private String jobId;
	@Column(name = "task_task_description")
	  private String description;
	@Column(name = "task_done_by")
	  private String doneBy;
	@Column(name = "task_is_done")
	  private byte isDone;
	@Column(name = "task_modified_by")
	  private String modifiedBy;
	@Column(name = "task_time_due_from")
	  private String timeDueFrom;
	@Column(name = "task_time_due_to")
	  private String timeDueTo;
	@Column(name = "task_date_modified")
	  private String dateModified;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDoneDate() {
		return doneDate;
	}
	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDoneBy() {
		return doneBy;
	}
	public void setDoneBy(String doneBy) {
		this.doneBy = doneBy;
	}
	public byte getIsDone() {
		return isDone;
	}
	public void setIsDone(byte isDone) {
		this.isDone = isDone;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getTimeDueFrom() {
		return timeDueFrom;
	}
	public void setTimeDueFrom(String timeDueFrom) {
		this.timeDueFrom = timeDueFrom;
	}
	public String getTimeDueTo() {
		return timeDueTo;
	}
	public void setTimeDueTo(String timeDueTo) {
		this.timeDueTo = timeDueTo;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		return Objects.hash(assignedDate, companyId, dateModified, description, doneBy, doneDate, dueDate, id, isDone,
				jobId, modifiedBy, note, role, timeDueFrom, timeDueTo, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(assignedDate, other.assignedDate) && Objects.equals(companyId, other.companyId)
				&& Objects.equals(dateModified, other.dateModified) && Objects.equals(description, other.description)
				&& Objects.equals(doneBy, other.doneBy) && Objects.equals(doneDate, other.doneDate)
				&& Objects.equals(dueDate, other.dueDate) && Objects.equals(id, other.id) && isDone == other.isDone
				&& Objects.equals(jobId, other.jobId) && Objects.equals(modifiedBy, other.modifiedBy)
				&& Objects.equals(note, other.note) && Objects.equals(role, other.role)
				&& Objects.equals(timeDueFrom, other.timeDueFrom) && Objects.equals(timeDueTo, other.timeDueTo)
				&& Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", note=" + note + ", user=" + user + ", role=" + role + ", dueDate=" + dueDate
				+ ", doneDate=" + doneDate + ", companyId=" + companyId + ", assignedDate=" + assignedDate + ", jobId="
				+ jobId + ", description=" + description + ", doneBy=" + doneBy + ", isDone=" + isDone + ", modifiedBy="
				+ modifiedBy + ", timeDueFrom=" + timeDueFrom + ", timeDueTo=" + timeDueTo + ", dateModified="
				+ dateModified + "]";
	}

	

}
