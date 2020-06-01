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
@Table(name="account_Opening_Business_Type_Info")
public class BusinessTypeInfo  implements Serializable{
	
	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "account_Opening_Business_Type_Info_id",nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  accountOpeningBusinessTypeInfoId;
	
	  
	 @Column(name = "premises_Number", nullable = false,length = 100)
	   	private String premisesNumber;
	
	 @Column(name = "name_on_License", nullable = false,length = 200)
	   	private String nameOnLicense;
	 
	 @Column(name = "trading_Name", nullable = false,length = 100)
	   	private String tradingName;
	 
	 
	 @Column(name = "owner_Name", nullable = false,length = 100)
	   	private String ownerName;
	 
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

	 @Column(name = "country_Tab", nullable = false,length = 100)
	   	private String countryTab;
	 
	 @Column(name = "change_of_Owner",columnDefinition = "TINYINT(1)")
	   	private Boolean changeofOwner;
	    
	    @Column(name = "northernland",columnDefinition = "TINYINT(1)")
	   	private Boolean northernland;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_Opening_Business_Info_id",columnDefinition="int(15)",nullable = false)
    private BusinessInfo accountOpeningBusinessInfo;

	public BusinessTypeInfo() {
	
		// TODO Auto-generated constructor stub
	}

	public BusinessTypeInfo(Long accountOpeningBusinessTypeInfoId, String premisesNumber,
			String nameOnLicense, String tradingName, String ownerName, String postCode, String addressLineOne,
			String addressLineTwo, String cityTab, String stateTab, String countryTab, Boolean changeofOwner,
			Boolean northernland, BusinessInfo accountOpeningBusinessInfo) {
		super();
		this.accountOpeningBusinessTypeInfoId = accountOpeningBusinessTypeInfoId;
		this.premisesNumber = premisesNumber;
		this.nameOnLicense = nameOnLicense;
		this.tradingName = tradingName;
		this.ownerName = ownerName;
		this.postCode = postCode;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.cityTab = cityTab;
		this.stateTab = stateTab;
		this.countryTab = countryTab;
		this.changeofOwner = changeofOwner;
		this.northernland = northernland;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public Long getAccountOpeningBusinessTypeInfoId() {
		return accountOpeningBusinessTypeInfoId;
	}

	public void setAccountOpeningBusinessTypeInfoId(Long accountOpeningBusinessTypeInfoId) {
		this.accountOpeningBusinessTypeInfoId = accountOpeningBusinessTypeInfoId;
	}

	public String getPremisesNumber() {
		return premisesNumber;
	}

	public void setPremisesNumber(String premisesNumber) {
		this.premisesNumber = premisesNumber;
	}

	public String getNameOnLicense() {
		return nameOnLicense;
	}

	public void setNameOnLicense(String nameOnLicense) {
		this.nameOnLicense = nameOnLicense;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public String getCountryTab() {
		return countryTab;
	}

	public void setCountryTab(String countryTab) {
		this.countryTab = countryTab;
	}

	public Boolean getChangeofOwner() {
		return changeofOwner;
	}

	public void setChangeofOwner(Boolean changeofOwner) {
		this.changeofOwner = changeofOwner;
	}

	public Boolean getNorthernland() {
		return northernland;
	}

	public void setNorthernland(Boolean northernland) {
		this.northernland = northernland;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	@Override
	public String toString() {
		return "AccountOpeningBusinessTypeInfo [accountOpeningBusinessTypeInfoId=" + accountOpeningBusinessTypeInfoId
				+ ", premisesNumber=" + premisesNumber + ", nameOnLicense=" + nameOnLicense + ", tradingName="
				+ tradingName + ", ownerName=" + ownerName + ", postCode=" + postCode + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo + ", cityTab=" + cityTab + ", stateTab="
				+ stateTab + ", countryTab=" + countryTab + ", changeofOwner=" + changeofOwner + ", northernland="
				+ northernland + ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + "]";
	}

	    
    



}
