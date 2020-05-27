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
@Table(name = "business_Order_System")
public class BusinessOrderSystem implements Serializable{

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "business_Order_System_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  businessOrderSystemId;
	
    @Column(name = "business_Order_System_name", nullable = false,length = 100)
	private String businessOrderSystemName;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessType.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bussiness_type_id",columnDefinition="int(15)")
    private BusinessType businessType;

	public BusinessOrderSystem() {
		
		// TODO Auto-generated constructor stub
	}

	public BusinessOrderSystem(Long businessOrderSystemId, String businessOrderSystemName, BusinessType businessType) {
		
		this.businessOrderSystemId = businessOrderSystemId;
		this.businessOrderSystemName = businessOrderSystemName;
		this.businessType = businessType;
	}

	public Long getBusinessOrderSystemId() {
		return businessOrderSystemId;
	}

	public void setBusinessOrderSystemId(Long businessOrderSystemId) {
		this.businessOrderSystemId = businessOrderSystemId;
	}

	public String getBusinessOrderSystemName() {
		return businessOrderSystemName;
	}

	public void setBusinessOrderSystemName(String businessOrderSystemName) {
		this.businessOrderSystemName = businessOrderSystemName;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "BusinessOrderSystem [businessOrderSystemId=" + businessOrderSystemId + ", businessOrderSystemName="
				+ businessOrderSystemName + ", businessType=" + businessType + "]";
	}
    
    

}
