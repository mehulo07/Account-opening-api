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
@Table(name = "trading_info_sub_supplier_tab", schema = "ifsapp")
public class TradingInformationSubSupplier implements Serializable {

	/**
	 * @author Hussain Doctor
	 */

	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "trading_info_sub_supplier_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tradingInformationSubSupplierId;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_opening_busi_info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessSupplierMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "business_Supplier_id", columnDefinition = "int(15)", nullable = false)
	private BusinessSupplierMaster businessSupplier;

	public TradingInformationSubSupplier() {
		
		// TODO Auto-generated constructor stub
	}

	public TradingInformationSubSupplier(Long tradingInformationSubSupplierId, BusinessInfo accountOpeningBusinessInfo,
			BusinessSupplierMaster businessSupplier) {
		super();
		this.tradingInformationSubSupplierId = tradingInformationSubSupplierId;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
		this.businessSupplier = businessSupplier;
	}

	public Long getTradingInformationSubSupplierId() {
		return tradingInformationSubSupplierId;
	}

	public void setTradingInformationSubSupplierId(Long tradingInformationSubSupplierId) {
		this.tradingInformationSubSupplierId = tradingInformationSubSupplierId;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public BusinessSupplierMaster getBusinessSupplier() {
		return businessSupplier;
	}

	public void setBusinessSupplier(BusinessSupplierMaster businessSupplier) {
		this.businessSupplier = businessSupplier;
	}

	@Override
	public String toString() {
		return "TradingInformationSubSupplier [tradingInformationSubSupplierId=" + tradingInformationSubSupplierId
				+ ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + ", businessSupplier="
				+ businessSupplier + "]";
	}

	
	

		

}
