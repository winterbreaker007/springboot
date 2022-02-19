package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "tblVisits")
public class Visit {

	@Id
	@Column(name = "visit_id")
	private String id;

	@Column(name = "visit_parent_job_id")
	private String jobId;

	@Column(name = "visit_number")
	private String number;

	@Column(name = "visit_date")
	private LocalDateTime date;

	@Column(name = "visit_day")
	private String day;

	@Column(name = "visit_time")
	private String time;

	@Column(name = "visit_hours")
	private Integer hours;

	@Column(name = "visit_monitor")
	private Boolean monitor;

	@Column(name = "visit_setup")
	private Boolean setup;

	@Column(name = "visit_takedown")
	private Boolean takedown;

	@Column(name = "visit_adjust")
	private Boolean adjust;

	@Column(name = "visit_missed_appointment")
	private Boolean missedAppointment;

	@Column(name = "visit_saved_by")
	private String createdBy;

	@Column(name = "visit_date_last_saved")
	private LocalDateTime updatedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Boolean IsMonitor() {
		return monitor;
	}

	public void setIsMonitor(Boolean monitor) {
		this.monitor = monitor;
	}

	public Boolean IsSetup() {
		return setup;
	}

	public void setIsSetup(Boolean setup) {
		this.setup = setup;
	}

	public Boolean IsTakedown() {
		return takedown;
	}

	public void setIsTakedown(Boolean takedown) {
		this.takedown = takedown;
	}

	public Boolean IsAdjust() {
		return adjust;
	}

	public void setIsAdjust(Boolean adjust) {
		this.adjust = adjust;
	}

	public Boolean IsMissedAppointment() {
		return missedAppointment;
	}

	public void setIsMissedAppointment(Boolean missedAppointment) {
		this.missedAppointment = missedAppointment;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", id)
			.append("jobId", jobId)
			.append("number", number)
			.append("date", date)
			.append("day", day)
			.append("time", time)
			.append("hours", hours)
			.append("monitor", monitor)
			.append("setup", setup)
			.append("takedown", takedown)
			.append("adjust", adjust)
			.append("missedAppointment", missedAppointment)
			.append("createdBy", createdBy)
			.append("updatedDate", updatedDate)
			.toString();
	}

}
