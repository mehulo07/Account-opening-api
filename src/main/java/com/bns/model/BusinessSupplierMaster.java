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
@Table(name = "business_supplier_tab" , schema = "ifsapp")
public class BusinessSupplierMaster implements Serializable  {

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "business_Supplier_id" )
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  businessSupplierId;
	
    @Column(name = "business_Supplier_name", nullable = false,length = 100)
	private String businessSupplierName;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessTypeMaster.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bussiness_type_id",columnDefinition="int(15)")
    private BusinessTypeMaster businessType;

	public BusinessSupplierMaster() {
		
		// TODO Auto-generated constructor stub
	}

	public BusinessSupplierMaster(Long businessSupplierId, String businessSupplierName, BusinessTypeMaster businessType) {
	
		this.businessSupplierId = businessSupplierId;
		this.businessSupplierName = businessSupplierName;
		this.businessType = businessType;
	}

	public Long getBusinessSupplierId() {
		return businessSupplierId;
	}

	public void setBusinessSupplierId(Long businessSupplierId) {
		this.businessSupplierId = businessSupplierId;
	}

	public String getBusinessSupplierName() {
		return businessSupplierName;
	}

	public void setBusinessSupplierName(String businessSupplierName) {
		this.businessSupplierName = businessSupplierName;
	}

	public BusinessTypeMaster getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessTypeMaster businessType) {
		this.businessType = businessType;
	}

	@Override
	public String toString() {
		return "BusinessSupplier [businessSupplierId=" + businessSupplierId + ", businessSupplierName="
				+ businessSupplierName + ", businessType=" + businessType + "]";
	}
	
    
    

}
