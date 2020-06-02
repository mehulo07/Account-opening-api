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
@Table(name="account_Opening_Trading_Info" , schema = "ifsapp")
public class TradingInfo  implements Serializable{
	

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "account_Opening_Trading_Info_id",nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  accountOpeningTradingInfoId;
	
	 @Column(name = "trading_Name", nullable = false,length = 100)
	   	private String tradingName;
	 
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
	 
	
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_Opening_Business_Info_id",columnDefinition="int(15)",nullable = false)
    private BusinessInfo accountOpeningBusinessInfo;



	public TradingInfo() {
		
		// TODO Auto-generated constructor stub
	}



	public TradingInfo(Long accountOpeningTradingInfoId, String tradingName, String postCode,
			String addressLineOne, String addressLineTwo, String cityTab, String stateTab, String countryTab,
			BusinessInfo accountOpeningBusinessInfo) {
		super();
		this.accountOpeningTradingInfoId = accountOpeningTradingInfoId;
		this.tradingName = tradingName;
		this.postCode = postCode;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.cityTab = cityTab;
		this.stateTab = stateTab;
		this.countryTab = countryTab;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}



	public Long getAccountOpeningTradingInfoId() {
		return accountOpeningTradingInfoId;
	}


	public void setAccountOpeningTradingInfoId(Long accountOpeningTradingInfoId) {
		this.accountOpeningTradingInfoId = accountOpeningTradingInfoId;
	}


	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
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

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	@Override
	public String toString() {
		return "AccountOpeningTradingInfo [accountOpeningTradingInfoId=" + accountOpeningTradingInfoId
				+ ", tradingName=" + tradingName + ", postCode=" + postCode + ", addressLineOne=" + addressLineOne
				+ ", addressLineTwo=" + addressLineTwo + ", cityTab=" + cityTab + ", stateTab=" + stateTab
				+ ", countryTab=" + countryTab + ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + "]";
	}

}
