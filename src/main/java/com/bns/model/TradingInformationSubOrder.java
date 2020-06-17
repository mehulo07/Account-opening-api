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
@Table(name = "trading_info_sub_order_tab", schema = "ifsapp")
public class TradingInformationSubOrder implements Serializable {
	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "trading_info_sub_order_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tradingInformationSubOrderId;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_opening_busi_info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessOrderSystemMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "business_order_system_id", columnDefinition = "int(15)", nullable = false)
	private BusinessOrderSystemMaster businessOrderSystem;

	public TradingInformationSubOrder() {
		
		// TODO Auto-generated constructor stub
	}

	public TradingInformationSubOrder(Long tradingInformationSubOrderId, BusinessInfo accountOpeningBusinessInfo,
			BusinessOrderSystemMaster businessOrderSystem) {
		
		this.tradingInformationSubOrderId = tradingInformationSubOrderId;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
		this.businessOrderSystem = businessOrderSystem;
	}

	public Long getTradingInformationSubOrderId() {
		return tradingInformationSubOrderId;
	}

	public void setTradingInformationSubOrderId(Long tradingInformationSubOrderId) {
		this.tradingInformationSubOrderId = tradingInformationSubOrderId;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public BusinessOrderSystemMaster getBusinessOrderSystem() {
		return businessOrderSystem;
	}

	public void setBusinessOrderSystem(BusinessOrderSystemMaster businessOrderSystem) {
		this.businessOrderSystem = businessOrderSystem;
	}

	@Override
	public String toString() {
		return "TradingInformationSubOrder [tradingInformationSubOrderId=" + tradingInformationSubOrderId
				+ ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + ", businessOrderSystem="
				+ businessOrderSystem + "]";
	}
	
	

}
