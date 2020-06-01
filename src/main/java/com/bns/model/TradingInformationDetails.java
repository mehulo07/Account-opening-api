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
@Table(name = "trading_Information_Details")
public class TradingInformationDetails implements Serializable {

	/**
	 * @author Hussain Doctor
	 */

	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "trading_Information_Details_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tradingInformationDetailsId;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_Opening_Business_Info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;

	@Column(name = "telephone_Number", nullable = false, length = 45)
	private String telephoneNumber;
	@Column(name = "fax_Number", nullable = false, length = 45)
	private String faxNumber;
	@Column(name = "website_url", nullable = false, length = 45)
	private String websiteurl;

	@Column(name = "buyer_Name", nullable = false, length = 45)
	private String buyerName;

	@Column(name = "moblie_No", nullable = false, length = 45)
	private String moblieNo;

	@Column(name = "email_Add", nullable = false, length = 45)
	private String emailAdd;

	@Column(name = "other_Contact_Name", nullable = false, length = 45)
	private String otherContactName;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessSupplierMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "business_Supplier_id", columnDefinition = "int(15)", nullable = false)
	private BusinessSupplierMaster businessSupplier;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessPmrMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "businessPmrId", columnDefinition = "int(15)", nullable = false)
	private BusinessPmrMaster businessPmr;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessBuyingGroupMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "businessBuyingGroupId", columnDefinition = "int(15)", nullable = false)
	private BusinessBuyingGroupMaster businessBuyingGroup;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessOrderSystemMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "businessOrderSystemId", columnDefinition = "int(15)", nullable = false)
	private BusinessOrderSystemMaster businessOrderSystem;

	public TradingInformationDetails() {
		
		// TODO Auto-generated constructor stub
	}

	public TradingInformationDetails(Long tradingInformationDetailsId,
			BusinessInfo accountOpeningBusinessInfo, String telephoneNumber, String faxNumber,
			String websiteurl, String buyerName, String moblieNo, String emailAdd, String otherContactName,
			BusinessSupplierMaster businessSupplier, BusinessPmrMaster businessPmr, BusinessBuyingGroupMaster businessBuyingGroup,
			BusinessOrderSystemMaster businessOrderSystem) {
		super();
		this.tradingInformationDetailsId = tradingInformationDetailsId;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
		this.telephoneNumber = telephoneNumber;
		this.faxNumber = faxNumber;
		this.websiteurl = websiteurl;
		this.buyerName = buyerName;
		this.moblieNo = moblieNo;
		this.emailAdd = emailAdd;
		this.otherContactName = otherContactName;
		this.businessSupplier = businessSupplier;
		this.businessPmr = businessPmr;
		this.businessBuyingGroup = businessBuyingGroup;
		this.businessOrderSystem = businessOrderSystem;
	}

	public Long getTradingInformationDetailsId() {
		return tradingInformationDetailsId;
	}

	public void setTradingInformationDetailsId(Long tradingInformationDetailsId) {
		this.tradingInformationDetailsId = tradingInformationDetailsId;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getWebsiteurl() {
		return websiteurl;
	}

	public void setWebsiteurl(String websiteurl) {
		this.websiteurl = websiteurl;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getMoblieNo() {
		return moblieNo;
	}

	public void setMoblieNo(String moblieNo) {
		this.moblieNo = moblieNo;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public String getOtherContactName() {
		return otherContactName;
	}

	public void setOtherContactName(String otherContactName) {
		this.otherContactName = otherContactName;
	}

	public BusinessSupplierMaster getBusinessSupplier() {
		return businessSupplier;
	}

	public void setBusinessSupplier(BusinessSupplierMaster businessSupplier) {
		this.businessSupplier = businessSupplier;
	}

	public BusinessPmrMaster getBusinessPmr() {
		return businessPmr;
	}

	public void setBusinessPmr(BusinessPmrMaster businessPmr) {
		this.businessPmr = businessPmr;
	}

	public BusinessBuyingGroupMaster getBusinessBuyingGroup() {
		return businessBuyingGroup;
	}

	public void setBusinessBuyingGroup(BusinessBuyingGroupMaster businessBuyingGroup) {
		this.businessBuyingGroup = businessBuyingGroup;
	}

	public BusinessOrderSystemMaster getBusinessOrderSystem() {
		return businessOrderSystem;
	}

	public void setBusinessOrderSystem(BusinessOrderSystemMaster businessOrderSystem) {
		this.businessOrderSystem = businessOrderSystem;
	}

	@Override
	public String toString() {
		return "TradingInformationDetails [tradingInformationDetailsId=" + tradingInformationDetailsId
				+ ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + ", telephoneNumber=" + telephoneNumber
				+ ", faxNumber=" + faxNumber + ", websiteurl=" + websiteurl + ", buyerName=" + buyerName + ", moblieNo="
				+ moblieNo + ", emailAdd=" + emailAdd + ", otherContactName=" + otherContactName + ", businessSupplier="
				+ businessSupplier + ", businessPmr=" + businessPmr + ", businessBuyingGroup=" + businessBuyingGroup
				+ ", businessOrderSystem=" + businessOrderSystem + "]";
	}
	
	

	
	
	

}
