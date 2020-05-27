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
@Table(name = "business_Buying_Group")
public class BusinessBuyingGroup implements Serializable {


	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "business_Buying_Group_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  businessBuyingGroupId;
	
    @Column(name = "business_Buying_Group_name", nullable = false,length = 100)
	private String businessBuyingGroupName;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessType.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bussiness_type_id",columnDefinition="int(15)")
    private BusinessType businessType;

	public BusinessBuyingGroup() {
		
		// TODO Auto-generated constructor stub
	}

	public BusinessBuyingGroup(Long businessBuyingGroupId, String businessBuyingGroupName, BusinessType businessType) {
		
		this.businessBuyingGroupId = businessBuyingGroupId;
		this.businessBuyingGroupName = businessBuyingGroupName;
		this.businessType = businessType;
	}

	public Long getBusinessBuyingGroupId() {
		return businessBuyingGroupId;
	}

	public void setBusinessBuyingGroupId(Long businessBuyingGroupId) {
		this.businessBuyingGroupId = businessBuyingGroupId;
	}

	public String getBusinessBuyingGroupName() {
		return businessBuyingGroupName;
	}

	public void setBusinessBuyingGroupName(String businessBuyingGroupName) {
		this.businessBuyingGroupName = businessBuyingGroupName;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "BusinessBuyingGroup [businessBuyingGroupId=" + businessBuyingGroupId + ", businessBuyingGroupName="
				+ businessBuyingGroupName + ", businessType=" + businessType + "]";
	}


	
	
}
