package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "tblAccounts")
public class TblAccounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "account_id")
    private String accountId;
    @Size(max = 35)
    @Column(name = "account_user_name")
    private String accountUserName;
    @Size(max = 25)
    @Column(name = "account_password")
    private String accountPassword;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "account_company_logo")
    private String accountCompanyLogo;
    @Size(max = 65)
    @Column(name = "account_company_name")
    private String accountCompanyName;

    public TblAccounts() {
    }

    public TblAccounts(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(String accountUserName) {
        this.accountUserName = accountUserName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountCompanyLogo() {
        return accountCompanyLogo;
    }

    public void setAccountCompanyLogo(String accountCompanyLogo) {
        this.accountCompanyLogo = accountCompanyLogo;
    }

    public String getAccountCompanyName() {
        return accountCompanyName;
    }

    public void setAccountCompanyName(String accountCompanyName) {
        this.accountCompanyName = accountCompanyName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAccounts)) {
            return false;
        }
        TblAccounts other = (TblAccounts) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "TblAccounts{" +
                "accountId='" + accountId + '\'' +
                ", accountUserName='" + accountUserName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountCompanyLogo='" + accountCompanyLogo + '\'' +
                ", accountCompanyName='" + accountCompanyName + '\'' +
                '}';
    }
}