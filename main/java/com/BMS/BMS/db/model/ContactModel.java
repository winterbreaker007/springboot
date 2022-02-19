package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.io.Serializable;

public class ContactModel implements Serializable {
    private User user;
    private String companyId;
    private String loggedInUser;

    public ContactModel() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
