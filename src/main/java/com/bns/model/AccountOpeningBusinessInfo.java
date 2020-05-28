package com.bns.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="account_Opening_Business_Info")
public class AccountOpeningBusinessInfo  implements Serializable{

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "account_Opening_Business_Info_id",nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  accountOpeningBusinessInfoId;
	
	 @OneToOne(fetch = FetchType.EAGER, targetEntity = CompanyType.class,cascade = CascadeType.ALL)
	 @JoinColumn(name = "company_id",columnDefinition="int(15)")
	 private CompanyType companyType;
	 
	 @Column(name = "company_Registration_Number", nullable = false,length = 100)
	   	private String companyRegistrationNumber;
	
	 @Column(name = "company_Registered_Address", nullable = false,length = 200)
	   	private String companyRegisteredAddress;
	 
	 @Column(name = "vat_Number", nullable = false,length = 100)
	   	private String vatNumber;
	 
	 @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessType.class,cascade = CascadeType.ALL)
	    @JoinColumn(name = "bussiness_type_id",columnDefinition="int(15)")
	    private BusinessType businessType;
	 
	 @Column(name = "Other_Company_Status", nullable = false,length = 100)
	   	private String OtherCompanyStatus;
	 
	 @Column(name = "company_Reg_Name", nullable = false,length = 100)
	   	private String companyRegName;
	
	 @Temporal(TemporalType.DATE)
		@Column(name = "date_of_Business_Commenced")
		private Date dateofBusinessCommenced;
	 
	 @Column(name = "Other_Business_ype", nullable = false,length = 100)
	   	private String OtherBusinessType;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = AccOpeningReg.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ao_pening_Reg_Info_id",columnDefinition="int(15)",nullable = false)
    private AccOpeningReg accOpeningReg;

	public AccountOpeningBusinessInfo() {
		
		// TODO Auto-generated constructor stub
	}

	public AccountOpeningBusinessInfo(Long accountOpeningBusinessInfoId, CompanyType companyType,
			String companyRegistrationNumber, String companyRegisteredAddress, String vatNumber,
			BusinessType businessType, String otherCompanyStatus, String companyRegName, Date dateofBusinessCommenced,
			String otherBusinessType, AccOpeningReg accOpeningReg) {
		
		this.accountOpeningBusinessInfoId = accountOpeningBusinessInfoId;
		this.companyType = companyType;
		this.companyRegistrationNumber = companyRegistrationNumber;
		this.companyRegisteredAddress = companyRegisteredAddress;
		this.vatNumber = vatNumber;
		this.businessType = businessType;
		OtherCompanyStatus = otherCompanyStatus;
		this.companyRegName = companyRegName;
		this.dateofBusinessCommenced = dateofBusinessCommenced;
		OtherBusinessType = otherBusinessType;
		this.accOpeningReg = accOpeningReg;
	}

	public Long getAccountOpeningBusinessInfoId() {
		return accountOpeningBusinessInfoId;
	}

	public void setAccountOpeningBusinessInfoId(Long accountOpeningBusinessInfoId) {
		this.accountOpeningBusinessInfoId = accountOpeningBusinessInfoId;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public String getCompanyRegistrationNumber() {
		return companyRegistrationNumber;
	}

	public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
		this.companyRegistrationNumber = companyRegistrationNumber;
	}

	public String getCompanyRegisteredAddress() {
		return companyRegisteredAddress;
	}

	public void setCompanyRegisteredAddress(String companyRegisteredAddress) {
		this.companyRegisteredAddress = companyRegisteredAddress;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public String getOtherCompanyStatus() {
		return OtherCompanyStatus;
	}

	public void setOtherCompanyStatus(String otherCompanyStatus) {
		OtherCompanyStatus = otherCompanyStatus;
	}

	public String getCompanyRegName() {
		return companyRegName;
	}

	public void setCompanyRegName(String companyRegName) {
		this.companyRegName = companyRegName;
	}

	public Date getDateofBusinessCommenced() {
		return dateofBusinessCommenced;
	}

	public void setDateofBusinessCommenced(Date dateofBusinessCommenced) {
		this.dateofBusinessCommenced = dateofBusinessCommenced;
	}

	public String getOtherBusinessType() {
		return OtherBusinessType;
	}

	public void setOtherBusinessType(String otherBusinessType) {
		OtherBusinessType = otherBusinessType;
	}

	public AccOpeningReg getAccOpeningReg() {
		return accOpeningReg;
	}

	public void setAccOpeningReg(AccOpeningReg accOpeningReg) {
		this.accOpeningReg = accOpeningReg;
	}

	@Override
	public String toString() {
		return "AccountOpeningBusinessInfo [accountOpeningBusinessInfoId=" + accountOpeningBusinessInfoId
				+ ", companyType=" + companyType + ", companyRegistrationNumber=" + companyRegistrationNumber
				+ ", companyRegisteredAddress=" + companyRegisteredAddress + ", vatNumber=" + vatNumber
				+ ", businessType=" + businessType + ", OtherCompanyStatus=" + OtherCompanyStatus + ", companyRegName="
				+ companyRegName + ", dateofBusinessCommenced=" + dateofBusinessCommenced + ", OtherBusinessType="
				+ OtherBusinessType + ", accOpeningReg=" + accOpeningReg + "]";
	}
	
    
    


	
	
}
