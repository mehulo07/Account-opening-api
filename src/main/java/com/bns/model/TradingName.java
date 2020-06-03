package com.bns.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_ord_tab" , schema = "ifsapp")
public class TradingName implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customer_no", nullable = false,length = 20)
	private String customerId;
	
	@Column(name="name" , nullable = true , length =100)
	private String tradingName;
	
	@Column(name="CUST_GRP" , nullable = false , length = 10)
	private String custGroup;
	
	@Column(name ="COMPANY" , nullable = false , length = 20)
	private String company;

//	@OneToOne(cascade =CascadeType.ALL , fetch = FetchType.EAGER)
//	@JoinColumn(name="customer_no", referencedColumnName="customer_id")
	private ExistingAccInfo existingAccInfo;
	
	public TradingName() {

	}

	public TradingName(String customerId, String tradingName, String custGroup, String company) {
		this.customerId = customerId;
		this.tradingName = tradingName;
		this.custGroup = custGroup;
		this.company = company;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getCustGroup() {
		return custGroup;
	}

	public void setCustGroup(String custGroup) {
		this.custGroup = custGroup;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public ExistingAccInfo getExistingAccInfo() {
		return existingAccInfo;
	}

	public void setExistingAccInfo(ExistingAccInfo existingAccInfo) {
		this.existingAccInfo = existingAccInfo;
	}

	@Override
	public String toString() {
		return "TradingName [customerId=" + customerId + ", tradingName=" + tradingName + ", custGroup=" + custGroup
				+ ", company=" + company + ", existingAccInfo=" + existingAccInfo + "]";
	}

}
