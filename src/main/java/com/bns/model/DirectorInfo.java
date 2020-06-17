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
@Table(name="acc_opening_director_info_tab" , schema = "ifsapp")
public class DirectorInfo implements Serializable{

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "acc_opening_director_info_id",nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  accountOpeningDirectorInfoId;
	
	  
	 @Column(name = "full_Name", nullable = false,length = 100)
	   	private String fullName;
	
	 @Column(name = "full_Address", nullable = false,length = 200)
	   	private String fullAddress;
	 
	 @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class,cascade = CascadeType.ALL)
	    @JoinColumn(name = "acc_opening_busi_info_id",columnDefinition="int(15)",nullable = false)
	    private BusinessInfo accountOpeningBusinessInfo;

	public DirectorInfo() {
		
		// TODO Auto-generated constructor stub
	}

	public DirectorInfo(Long accountOpeningDirectorInfoId, String fullName, String fullAddress,
			BusinessInfo accountOpeningBusinessInfo) {
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

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	@Override
	public String toString() {
		return "AccountOpeningDirectorInfo [accountOpeningDirectorInfoId=" + accountOpeningDirectorInfoId
				+ ", fullName=" + fullName + ", fullAddress=" + fullAddress + ", accountOpeningBusinessInfo="
				+ accountOpeningBusinessInfo + "]";
	}
	 
	
	 
	
	

}
