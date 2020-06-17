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
@Table(name = "business_buying_group_tab" , schema = "ifsapp")
public class BusinessBuyingGroupMaster implements Serializable {


	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "business_Buying_Group_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  businessBuyingGroupId;
	
    @Column(name = "business_Buying_Group_name", nullable = false,length = 100)
	private String businessBuyingGroupName;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessTypeMaster.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bussiness_type_id",columnDefinition="int(15)")
    private BusinessTypeMaster businessType;

	public BusinessBuyingGroupMaster() {
		
		// TODO Auto-generated constructor stub
	}

	public BusinessBuyingGroupMaster(Long businessBuyingGroupId, String businessBuyingGroupName, BusinessTypeMaster businessType) {
		
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

	public BusinessTypeMaster getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessTypeMaster businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "BusinessBuyingGroup [businessBuyingGroupId=" + businessBuyingGroupId + ", businessBuyingGroupName="
				+ businessBuyingGroupName + ", businessType=" + businessType + "]";
	}
	
}
