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
@Table(name = "trading_info_sub_pmr_tab", schema = "ifsapp")
public class TradingInformationSubPmr implements Serializable {

	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "trading_info_sub_pmr_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tradingInformationSubPmrId;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_opening_busi_info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessPmrMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "business_pmr_id", columnDefinition = "int(15)", nullable = false)
	private BusinessPmrMaster businessPmr;

	public TradingInformationSubPmr() {
	
		// TODO Auto-generated constructor stub
	}

	public TradingInformationSubPmr(Long tradingInformationSubPmrId, BusinessInfo accountOpeningBusinessInfo,
			BusinessPmrMaster businessPmr) {
		
		this.tradingInformationSubPmrId = tradingInformationSubPmrId;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
		this.businessPmr = businessPmr;
	}

	public Long getTradingInformationSubPmrId() {
		return tradingInformationSubPmrId;
	}

	public void setTradingInformationSubPmrId(Long tradingInformationSubPmrId) {
		this.tradingInformationSubPmrId = tradingInformationSubPmrId;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public BusinessPmrMaster getBusinessPmr() {
		return businessPmr;
	}

	public void setBusinessPmr(BusinessPmrMaster businessPmr) {
		this.businessPmr = businessPmr;
	}

	@Override
	public String toString() {
		return "TradingInformationSubPmr [tradingInformationSubPmrId=" + tradingInformationSubPmrId
				+ ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + ", businessPmr=" + businessPmr + "]";
	}
	

	
}
