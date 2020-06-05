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
@Table(name = "business_pmr_tab" , schema = "ifsapp")
public class BusinessPmrMaster implements Serializable {

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "business_Pmr_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  businessPmrId;
	
    @Column(name = "business_Pmr_name", nullable = false,length = 100)
	private String businessPmrName;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessTypeMaster.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bussiness_type_id",columnDefinition="int(15)")
    private BusinessTypeMaster businessType;

	public BusinessPmrMaster() {
		
		// TODO Auto-generated constructor stub
	}

	public BusinessPmrMaster(Long businessPmrId, String businessPmrName, BusinessTypeMaster businessType) {
		
		this.businessPmrId = businessPmrId;
		this.businessPmrName = businessPmrName;
		this.businessType = businessType;
	}

	public Long getBusinessPmrId() {
		return businessPmrId;
	}

	public void setBusinessPmrId(Long businessPmrId) {
		this.businessPmrId = businessPmrId;
	}

	public String getBusinessPmrName() {
		return businessPmrName;
	}

	public void setBusinessPmrName(String businessPmrName) {
		this.businessPmrName = businessPmrName;
	}

	public BusinessTypeMaster getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessTypeMaster businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "BusinessPmr [businessPmrId=" + businessPmrId + ", businessPmrName=" + businessPmrName
				+ ", businessType=" + businessType + "]";
	}
    
	
    
    

}
