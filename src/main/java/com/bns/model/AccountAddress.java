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
@Table(name="acc_opening_address_tab" , schema = "ifsapp")
public class AccountAddress  implements Serializable{
	
	
	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "acc_opening_address_tab_id",nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  accountOpeningAddressTabId;
	
	  
	 @Column(name = "post_Code", nullable = false,length = 100)
	   	private String postCode;
	
	 @Column(name = "address_Line1", nullable = false,length = 200)
	   	private String addressLineOne;
	 
	 @Column(name = "address_Line2", nullable = false,length = 100)
	   	private String addressLineTwo;
	 
	 
	 @Column(name = "city_Tab", nullable = false,length = 100)
	   	private String cityTab;
	 
	 @Column(name = "state_Tab", nullable = false,length = 100)
	   	private String stateTab;
	
	 @Column(name = "cqc_Name", nullable = false,length = 100)
	   	private String cqcName;
	 
	 @Column(name = "country_Tab", nullable = false,length = 100)
	   	private String countryTab;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_opening_business_info_id",columnDefinition="int(15)",nullable = false)
    private BusinessInfo accountOpeningBusinessInfo;

	public AccountAddress() {
		
		// TODO Auto-generated constructor stub
	}

	public AccountAddress(Long accountOpeningAddressTabId, String postCode, String addressLineOne,
			String addressLineTwo, String cityTab, String stateTab, String cqcName, String countryTab,
			BusinessInfo accountOpeningBusinessInfo) {
		super();
		this.accountOpeningAddressTabId = accountOpeningAddressTabId;
		this.postCode = postCode;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.cityTab = cityTab;
		this.stateTab = stateTab;
		this.cqcName = cqcName;
		this.countryTab = countryTab;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public Long getAccountOpeningAddressTabId() {
		return accountOpeningAddressTabId;
	}

	public void setAccountOpeningAddressTabId(Long accountOpeningAddressTabId) {
		this.accountOpeningAddressTabId = accountOpeningAddressTabId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCityTab() {
		return cityTab;
	}

	public void setCityTab(String cityTab) {
		this.cityTab = cityTab;
	}

	public String getStateTab() {
		return stateTab;
	}

	public void setStateTab(String stateTab) {
		this.stateTab = stateTab;
	}

	public String getCqcName() {
		return cqcName;
	}

	public void setCqcName(String cqcName) {
		this.cqcName = cqcName;
	}

	public String getCountryTab() {
		return countryTab;
	}

	public void setCountryTab(String countryTab) {
		this.countryTab = countryTab;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	@Override
	public String toString() {
		return "AccountOpeningAddressTab [accountOpeningAddressTabId=" + accountOpeningAddressTabId + ", postCode="
				+ postCode + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", cityTab="
				+ cityTab + ", stateTab=" + stateTab + ", cqcName=" + cqcName + ", countryTab=" + countryTab
				+ ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + "]";
	}
}
