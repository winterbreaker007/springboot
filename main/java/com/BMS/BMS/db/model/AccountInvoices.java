package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "tblAccountInvoices")
public class AccountInvoices implements Serializable {
	@Id
	@Column(name = "invoice_id")
	private String id;
	
	@Column(name = "customer_invoice_data")
	private String customerData;
	
	@Column(name = "subscription_id")
	private String subscriptionId;
	
	@Column(name = "parent_plan_history_id")
	private String historyId;
	
	@Column(name = "invoice_period_start_date")
	private String startDate;
	
	@Column(name = "invoice_period_end_date")
	private String endDate;

	@Column(name = "invoice_description")
	private String description;
	
	@Column(name = "invoice_amount")
	private Long amount;
	
	@Column(name = "invoice_create_date")
	private String createDate;
	
	@Column(name = "invoice_due_date")
	private String dueDate;
	
	@Column(name = "invoice_paid_date")
	private String paidDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerData() {
		return customerData;
	}

	public void setCustomerData(String customerData) {
		this.customerData = customerData;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, createDate, customerData, description, dueDate, endDate, historyId, id, paidDate,
				startDate, subscriptionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountInvoices other = (AccountInvoices) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(createDate, other.createDate)
				&& Objects.equals(customerData, other.customerData) && Objects.equals(description, other.description)
				&& Objects.equals(dueDate, other.dueDate) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(historyId, other.historyId) && Objects.equals(id, other.id)
				&& Objects.equals(paidDate, other.paidDate) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(subscriptionId, other.subscriptionId);
	}

	@Override
	public String toString() {
		return "AccountInvoices [id=" + id + ", customerData=" + customerData + ", subscriptionId=" + subscriptionId
				+ ", historyId=" + historyId + ", startDate=" + startDate + ", endDate=" + endDate + ", description="
				+ description + ", amount=" + amount + ", createDate=" + createDate + ", dueDate=" + dueDate
				+ ", paidDate=" + paidDate + "]";
	}
	
	
	
	
}