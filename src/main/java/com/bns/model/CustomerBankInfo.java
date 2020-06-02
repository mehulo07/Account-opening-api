package com.bns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer_bank_info_tab" , schema = "ifsapp")
public class CustomerBankInfo implements Serializable {

	/**
	 * 
	 * @author rathomoh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_bank_info_Id",nullable = false)
	private long custBankInfoId;
	@Column(name = "cust_name")
	private String custName;
	@Column(name = "cust_sur_name")
	private String custSurName;
	@Column(name = "cust_acc_no")
	private String custAccNo;
	@Column(name = "cust_sort_code")
	private String custSortCode;
	@Column(name = "cust_ref")
	private String custReference;
	@Column(name = "cust_bank_name")
	private String custBankName;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cust_date")
	private Date custDate;
	@Column(name = "business_info_id")
	private Long businessInfoId;
	@Column(name = "updated_by",nullable = false)
	private String updatedBy;
	public CustomerBankInfo() {
		super();
	}
	public CustomerBankInfo(long custBankInfoId, String custName, String custSurName, String custAccNo,
			String custSortCode, String custReference, String custBankName, Date custDate, Long businessInfoId,
			String updatedBy) {
		super();
		this.custBankInfoId = custBankInfoId;
		this.custName = custName;
		this.custSurName = custSurName;
		this.custAccNo = custAccNo;
		this.custSortCode = custSortCode;
		this.custReference = custReference;
		this.custBankName = custBankName;
		this.custDate = custDate;
		this.businessInfoId = businessInfoId;
		this.updatedBy = updatedBy;
	}
	public long getCustBankInfoId() {
		return custBankInfoId;
	}
	public void setCustBankInfoId(long custBankInfoId) {
		this.custBankInfoId = custBankInfoId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSurName() {
		return custSurName;
	}
	public void setCustSurName(String custSurName) {
		this.custSurName = custSurName;
	}
	public String getCustAccNo() {
		return custAccNo;
	}
	public void setCustAccNo(String custAccNo) {
		this.custAccNo = custAccNo;
	}
	public String getCustSortCode() {
		return custSortCode;
	}
	public void setCustSortCode(String custSortCode) {
		this.custSortCode = custSortCode;
	}
	public String getCustReference() {
		return custReference;
	}
	public void setCustReference(String custReference) {
		this.custReference = custReference;
	}
	public String getCustBankName() {
		return custBankName;
	}
	public void setCustBankName(String custBankName) {
		this.custBankName = custBankName;
	}
	public Date getCustDate() {
		return custDate;
	}
	public void setCustDate(Date custDate) {
		this.custDate = custDate;
	}
	public Long getBusinessInfoId() {
		return businessInfoId;
	}
	public void setBusinessInfoId(Long businessInfoId) {
		this.businessInfoId = businessInfoId;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "CustomerBankInfo [custBankInfoId=" + custBankInfoId + ", custName=" + custName + ", custSurName="
				+ custSurName + ", custAccNo=" + custAccNo + ", custSortCode=" + custSortCode + ", custReference="
				+ custReference + ", custBankName=" + custBankName + ", custDate=" + custDate + ", businessInfoId="
				+ businessInfoId + ", updatedBy=" + updatedBy + "]";
	}
	
	
	

}
