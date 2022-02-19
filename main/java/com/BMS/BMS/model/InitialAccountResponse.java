package com.blackwater.blackwaterbillingmanagementsystem.model;

import java.util.List;
import java.util.Objects;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Account;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountInvoices;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountPlans;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountSubs;

public class InitialAccountResponse {
	public InitialAccountResponse(Account account, List<AccountInvoices> invoices, List<AccountPlans> plans,
			List<AccountSubs> subscriptions) {
		
		this.account = account;
		this.invoices = invoices;
		this.plans = plans;
		this.subscriptions = subscriptions;
	}
	Account account;
	List<AccountInvoices> invoices;
	List<AccountPlans> plans;
	List<AccountSubs> subscriptions;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<AccountInvoices> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<AccountInvoices> invoices) {
		this.invoices = invoices;
	}
	public List<AccountPlans> getPlans() {
		return plans;
	}
	public void setPlans(List<AccountPlans> plans) {
		this.plans = plans;
	}
	public List<AccountSubs> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<AccountSubs> subscriptions) {
		this.subscriptions = subscriptions;
	}
	@Override
	public int hashCode() {
		return Objects.hash(account, invoices, plans, subscriptions);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InitialAccountResponse other = (InitialAccountResponse) obj;
		return Objects.equals(account, other.account) && Objects.equals(invoices, other.invoices)
				&& Objects.equals(plans, other.plans) && Objects.equals(subscriptions, other.subscriptions);
	}
	@Override
	public String toString() {
		return "InitialAccountResponse [account=" + account + ", invoices=" + invoices + ", plans=" + plans
				+ ", subscriptions=" + subscriptions + "]";
	}
}
