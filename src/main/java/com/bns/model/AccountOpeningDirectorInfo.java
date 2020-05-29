package com.bns.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account_Opening_Director_Info")
public class AccountOpeningDirectorInfo implements Serializable{

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "account_Opening_Director_Info_id",nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  accountOpeningDirectorInfoId;
	
	  
	 @Column(name = "full_Name", nullable = false,length = 100)
	   	private String fullName;
	
	 @Column(name = "full_Address", nullable = false,length = 200)
	   	private String fullAddress;
	 
	 @OneToOne(fetch = FetchType.EAGER, targetEntity = AccountOpeningBusinessInfo.class,cascade = CascadeType.ALL)
	    @JoinColumn(name = "account_Opening_Business_Info_id",columnDefinition="int(15)",nullable = false)
	    private AccountOpeningBusinessInfo accountOpeningBusinessInfo;

	public AccountOpeningDirectorInfo() {
		
		// TODO Auto-generated constructor stub
	}

	public AccountOpeningDirectorInfo(Long accountOpeningDirectorInfoId, String fullName, String fullAddress,
			AccountOpeningBusinessInfo accountOpeningBusinessInfo) {
		super();
		this.accountOpeningDirectorInfoId = accountOpeningDirectorInfoId;
		this.fullName = fullName;
		this.fullAddress = fullAddress;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public Long getAccountOpeningDirectorInfoId() {
		return accountOpeningDirectorInfoId;
	}

	public void setAccountOpeningDirectorInfoId(Long accountOpeningDirectorInfoId) {
		this.accountOpeningDirectorInfoId = accountOpeningDirectorInfoId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public AccountOpeningBusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(AccountOpeningBusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	@Override
	public String toString() {
		return "AccountOpeningDirectorInfo [accountOpeningDirectorInfoId=" + accountOpeningDirectorInfoId
				+ ", fullName=" + fullName + ", fullAddress=" + fullAddress + ", accountOpeningBusinessInfo="
				+ accountOpeningBusinessInfo + "]";
	}
	 
	
	 
	
	

}
