package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info_address_tab" , schema = "ifsapp")
public class ExistingAccInfo implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "customer_id", nullable = false,length = 20)
	private String customerId;
	
	@Column(name = "ADDRESS1", nullable = false,length = 35)
   	private String addressLineOne;
	
	@Column(name = "ADDRESS2", nullable = false,length = 35)
   	private String addressLineTwo;
	
	@Column(name = "ZIP_CODE", nullable = false,length = 35)
   	private String postCode;
	
	@Column(name = "CITY", nullable = false,length = 35)
   	private String cityTab;
	
	@Column(name = "STATE", nullable = true,length = 35)
	private String stateTab;

	@Column(name = "COUNTY", nullable = true,length = 35)
	private String countryTab;
	
	public ExistingAccInfo() {
	}

	public ExistingAccInfo(String customerId, String addressLineOne, String addressLineTwo, String postCode,
			String cityTab, String stateTab, String countryTab) {
		super();
		this.customerId = customerId;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.postCode = postCode;
		this.cityTab = cityTab;
		this.stateTab = stateTab;
		this.countryTab = countryTab;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	@Override
	public String toString() {
		return "ExistingAccInfo [customerId=" + customerId + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", postCode=" + postCode + ", cityTab=" + cityTab + ", stateTab=" + stateTab
				+ ", countryTab=" + countryTab + "]";
	}
	
}
