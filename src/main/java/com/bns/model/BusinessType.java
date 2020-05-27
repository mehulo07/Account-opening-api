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
@Table(name = "business_Type")
public class BusinessType implements Serializable {

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "business_type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  businessTypeId;
	
    @Column(name = "business_type_name", nullable = false,length = 100)
	private String businessTypeName;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = CompanyType.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id",columnDefinition="int(15)")
    private CompanyType companyType;

	public BusinessType() {
		
	}

	public BusinessType(Long businessTypeId, String businessTypeName, CompanyType companyType) {
		
		this.businessTypeId = businessTypeId;
		this.businessTypeName = businessTypeName;
		this.companyType = companyType;
	}

	public Long getBusinessTypeId() {
		return businessTypeId;
	}

	public void setBusinessTypeId(Long businessTypeId) {
		this.businessTypeId = businessTypeId;
	}

	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BusinessType [businessTypeId=" + businessTypeId + ", businessTypeName=" + businessTypeName
				+ ", companyType=" + companyType + "]";
	}
    
    


}
