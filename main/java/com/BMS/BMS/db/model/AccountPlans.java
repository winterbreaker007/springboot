package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblAccountPlans")
public class AccountPlans implements Serializable {
	@Id
	@Column(name = "plan_id")
	private String id;
	
	@Column(name = "plan_name")
	private String planName;
	
	@Column(name = "plan_features")
	private String planfeatures;
	
	@Column(name = "plan_initial_cost")
	private String planInitialCost;
	
	@Column(name = "plan_cost_per_additional_company")
	private String costPerAdditional;
	
	@Column(name = "plan_cost_per_user_each_company")
	private String costPerDevice;
	
	@Column(name = "plan_subscription_months")
	private String subscriptionMonth;
	
	@Column(name = "Plan_cost_per_month")
	private String costPerMonth;
	
	@Column(name = "plan_is_active")
	private String isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanfeatures() {
		return planfeatures;
	}

	public void setPlanfeatures(String planfeatures) {
		this.planfeatures = planfeatures;
	}

	public String getPlanInitialCost() {
		return planInitialCost;
	}

	public void setPlanInitialCost(String planInitialCost) {
		this.planInitialCost = planInitialCost;
	}

	public String getCostPerAdditional() {
		return costPerAdditional;
	}

	public void setCostPerAdditional(String costPerAdditional) {
		this.costPerAdditional = costPerAdditional;
	}

	public String getCostPerDevice() {
		return costPerDevice;
	}

	public void setCostPerDevice(String costPerDevice) {
		this.costPerDevice = costPerDevice;
	}

	public String getSubscriptionMonth() {
		return subscriptionMonth;
	}

	public void setSubscriptionMonth(String subscriptionMonth) {
		this.subscriptionMonth = subscriptionMonth;
	}

	public String getCostPerMonth() {
		return costPerMonth;
	}

	public void setCostPerMonth(String costPerMonth) {
		this.costPerMonth = costPerMonth;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "AccountPlans [id=" + id + ", planName=" + planName + ", planfeatures=" + planfeatures
				+ ", planInitialCost=" + planInitialCost + ", costPerAdditional=" + costPerAdditional
				+ ", costPerDevice=" + costPerDevice + ", subscriptionMonth=" + subscriptionMonth + ", costPerMonth="
				+ costPerMonth + ", isActive=" + isActive + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(costPerAdditional, costPerDevice, costPerMonth, id, isActive, planInitialCost, planName,
				planfeatures, subscriptionMonth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountPlans other = (AccountPlans) obj;
		return Objects.equals(costPerAdditional, other.costPerAdditional)
				&& Objects.equals(costPerDevice, other.costPerDevice)
				&& Objects.equals(costPerMonth, other.costPerMonth) && Objects.equals(id, other.id)
				&& Objects.equals(isActive, other.isActive) && Objects.equals(planInitialCost, other.planInitialCost)
				&& Objects.equals(planName, other.planName) && Objects.equals(planfeatures, other.planfeatures)
				&& Objects.equals(subscriptionMonth, other.subscriptionMonth);
	}
	
}
