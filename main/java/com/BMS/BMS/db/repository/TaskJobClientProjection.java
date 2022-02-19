package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Task;

public interface TaskJobClientProjection {
	public Task getTask();
	public Job getJob();
	public Client getClient();
}
