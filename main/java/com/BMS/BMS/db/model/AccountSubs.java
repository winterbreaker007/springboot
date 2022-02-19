package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblAccountSubscriptions")
public class AccountSubs implements Serializable {
	@Id
	@Column(name = "subscription_id")
	private String id;
	
	@Column(name = "subscription_parent_account_id")
	private String accountId;
	
	@Column(name = "subscription_trial_period_start_date")
	private String trialStartDate;
	@Column(name = "subscription_trial_period_end_date")
	private String trialEndDate;
	
	@Column(name = "subscription_subscribe_after_trial")
	private String afterTrial;
	
	@Column(name = "subscription_current_plan_id")
	private String planId;
	
	@Column(name = "subscription_offer_id")
	private String offerId;
	
	@Column(name = "subscription_offer_start_date")
	private String offerStartDate;
	
	@Column(name = "subscription_offer_end_date")
	private String offerEndDate;
	
	@Column(name = "subscription_date_subscribed")
	private String dateSubscribed;
	
	@Column(name = "subscription_valid_to")
	private String validTo;
	
	@Column(name = "subscription_date_unsubscribed")
	private String dateUnsubscribed;
	
	@Column(name = "subscription_date_last_saved")
	private String dateLastSaved;
	
	@Column(name = "subscription_unsubscribe_reason")
	private String unsubscribeReason;
	@Column(name = "subscription_unsubscribe_message")
	private String unsubscribeMessage;
	@Column(name = "subscription_active")
	private String active;
	@Column(name = "subscription_deactivate_date")
	private String deactiveDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getTrialStartDate() {
		return trialStartDate;
	}
	public void setTrialStartDate(String trialStartDate) {
		this.trialStartDate = trialStartDate;
	}
	public String getTrialEndDate() {
		return trialEndDate;
	}
	public void setTrialEndDate(String trialEndDate) {
		this.trialEndDate = trialEndDate;
	}
	public String getAfterTrial() {
		return afterTrial;
	}
	public void setAfterTrial(String afterTrial) {
		this.afterTrial = afterTrial;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public String getOfferStartDate() {
		return offerStartDate;
	}
	public void setOfferStartDate(String offerStartDate) {
		this.offerStartDate = offerStartDate;
	}
	public String getOfferEndDate() {
		return offerEndDate;
	}
	public void setOfferEndDate(String offerEndDate) {
		this.offerEndDate = offerEndDate;
	}
	public String getDateSubscribed() {
		return dateSubscribed;
	}
	public void setDateSubscribed(String dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public String getDateUnsubscribed() {
		return dateUnsubscribed;
	}
	public void setDateUnsubscribed(String dateUnsubscribed) {
		this.dateUnsubscribed = dateUnsubscribed;
	}
	public String getDateLastSaved() {
		return dateLastSaved;
	}
	public void setDateLastSaved(String dateLastSaved) {
		this.dateLastSaved = dateLastSaved;
	}
	public String getUnsubscribeReason() {
		return unsubscribeReason;
	}
	public void setUnsubscribeReason(String unsubscribeReason) {
		this.unsubscribeReason = unsubscribeReason;
	}
	public String getUnsubscribeMessage() {
		return unsubscribeMessage;
	}
	public void setUnsubscribeMessage(String unsubscribeMessage) {
		this.unsubscribeMessage = unsubscribeMessage;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getDeactiveDate() {
		return deactiveDate;
	}
	public void setDeactiveDate(String deactiveDate) {
		this.deactiveDate = deactiveDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountId, active, afterTrial, dateLastSaved, dateSubscribed, dateUnsubscribed,
				deactiveDate, id, offerEndDate, offerId, offerStartDate, planId, trialEndDate, trialStartDate,
				unsubscribeMessage, unsubscribeReason, validTo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountSubs other = (AccountSubs) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(active, other.active)
				&& Objects.equals(afterTrial, other.afterTrial) && Objects.equals(dateLastSaved, other.dateLastSaved)
				&& Objects.equals(dateSubscribed, other.dateSubscribed)
				&& Objects.equals(dateUnsubscribed, other.dateUnsubscribed)
				&& Objects.equals(deactiveDate, other.deactiveDate) && Objects.equals(id, other.id)
				&& Objects.equals(offerEndDate, other.offerEndDate) && Objects.equals(offerId, other.offerId)
				&& Objects.equals(offerStartDate, other.offerStartDate) && Objects.equals(planId, other.planId)
				&& Objects.equals(trialEndDate, other.trialEndDate)
				&& Objects.equals(trialStartDate, other.trialStartDate)
				&& Objects.equals(unsubscribeMessage, other.unsubscribeMessage)
				&& Objects.equals(unsubscribeReason, other.unsubscribeReason) && Objects.equals(validTo, other.validTo);
	}
	@Override
	public String toString() {
		return "AccountSubs [id=" + id + ", accountId=" + accountId + ", trialStartDate=" + trialStartDate
				+ ", trialEndDate=" + trialEndDate + ", afterTrial=" + afterTrial + ", planId=" + planId + ", offerId="
				+ offerId + ", offerStartDate=" + offerStartDate + ", offerEndDate=" + offerEndDate
				+ ", dateSubscribed=" + dateSubscribed + ", validTo=" + validTo + ", dateUnsubscribed="
				+ dateUnsubscribed + ", dateLastSaved=" + dateLastSaved + ", unsubscribeReason=" + unsubscribeReason
				+ ", unsubscribeMessage=" + unsubscribeMessage + ", active=" + active + ", deactiveDate=" + deactiveDate
				+ "]";
	}
	
		
	
		
}
