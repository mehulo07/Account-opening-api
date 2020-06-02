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
@Table(name = "account_Opening_Trade_Reference" , schema = "ifsapp")
public class TradeReference implements Serializable {

	/**
	 * @author Hussain Doctor
	 */

	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "account_Opening_Trade_Reference_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountOpeningTradeReferenceId;

	@Column(name = "company_Name", nullable = false, length = 100)
	private String companyName;

	@Column(name = "contact_Name", nullable = false, length = 100)
	private String contactName;

	@Column(name = "telephone_Number", nullable = false, length = 100)
	private String telephoneNumber;

	@Column(name = "email_Address", nullable = false, length = 100)
	private String emailAddress;

	@Column(name = "company_NameTwo", nullable = false, length = 100)
	private String companyNameTwo;

	@Column(name = "contact_NameTwo", nullable = false, length = 100)
	private String contactNameTwo;

	@Column(name = "telephone_NumberTwo", nullable = false, length = 100)
	private String telephoneNumberTwo;

	@Column(name = "email_AddressTwo", nullable = false, length = 100)
	private String emailAddressTwo;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_Opening_Business_Info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;

	public TradeReference() {
		
		// TODO Auto-generated constructor stub
	}

	public TradeReference(Long accountOpeningTradeReferenceId, String companyName, String contactName,
			String telephoneNumber, String emailAddress, String companyNameTwo, String contactNameTwo,
			String telephoneNumberTwo, String emailAddressTwo, BusinessInfo accountOpeningBusinessInfo) {
		
		this.accountOpeningTradeReferenceId = accountOpeningTradeReferenceId;
		this.companyName = companyName;
		this.contactName = contactName;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.companyNameTwo = companyNameTwo;
		this.contactNameTwo = contactNameTwo;
		this.telephoneNumberTwo = telephoneNumberTwo;
		this.emailAddressTwo = emailAddressTwo;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public Long getAccountOpeningTradeReferenceId() {
		return accountOpeningTradeReferenceId;
	}

	public void setAccountOpeningTradeReferenceId(Long accountOpeningTradeReferenceId) {
		this.accountOpeningTradeReferenceId = accountOpeningTradeReferenceId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCompanyNameTwo() {
		return companyNameTwo;
	}

	public void setCompanyNameTwo(String companyNameTwo) {
		this.companyNameTwo = companyNameTwo;
	}

	public String getContactNameTwo() {
		return contactNameTwo;
	}

	public void setContactNameTwo(String contactNameTwo) {
		this.contactNameTwo = contactNameTwo;
	}

	public String getTelephoneNumberTwo() {
		return telephoneNumberTwo;
	}

	public void setTelephoneNumberTwo(String telephoneNumberTwo) {
		this.telephoneNumberTwo = telephoneNumberTwo;
	}

	public String getEmailAddressTwo() {
		return emailAddressTwo;
	}

	public void setEmailAddressTwo(String emailAddressTwo) {
		this.emailAddressTwo = emailAddressTwo;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	@Override
	public String toString() {
		return "AccountOpeningTradeReference [accountOpeningTradeReferenceId=" + accountOpeningTradeReferenceId
				+ ", companyName=" + companyName + ", contactName=" + contactName + ", telephoneNumber="
				+ telephoneNumber + ", emailAddress=" + emailAddress + ", companyNameTwo=" + companyNameTwo
				+ ", contactNameTwo=" + contactNameTwo + ", telephoneNumberTwo=" + telephoneNumberTwo
				+ ", emailAddressTwo=" + emailAddressTwo + ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo
				+ "]";
	}
	
	
	
	 
	
	
	
	
	

}
