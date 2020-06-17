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
@Table(name = "trading_info_sub_buying_tab", schema = "ifsapp")
public class TradingInformationSubBuying implements Serializable {
	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "trading_info_sub_buying_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tradingInformationSubBuyingId;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_opening_busi_info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessBuyingGroupMaster.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "business_buying_group_id", columnDefinition = "int(15)", nullable = false)
	private BusinessBuyingGroupMaster businessBuyingGroup;

	public TradingInformationSubBuying() {

		// TODO Auto-generated constructor stub
	}

	public TradingInformationSubBuying(Long tradingInformationSubBuyingId, BusinessInfo accountOpeningBusinessInfo,
			BusinessBuyingGroupMaster businessBuyingGroup) {
		
		this.tradingInformationSubBuyingId = tradingInformationSubBuyingId;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
		this.businessBuyingGroup = businessBuyingGroup;
	}

	public Long getTradingInformationSubBuyingId() {
		return tradingInformationSubBuyingId;
	}

	public void setTradingInformationSubBuyingId(Long tradingInformationSubBuyingId) {
		this.tradingInformationSubBuyingId = tradingInformationSubBuyingId;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public BusinessBuyingGroupMaster getBusinessBuyingGroup() {
		return businessBuyingGroup;
	}

	public void setBusinessBuyingGroup(BusinessBuyingGroupMaster businessBuyingGroup) {
		this.businessBuyingGroup = businessBuyingGroup;
	}

	@Override
	public String toString() {
		return "TradingInformationSubBuying [tradingInformationSubBuyingId=" + tradingInformationSubBuyingId
				+ ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + ", businessBuyingGroup="
				+ businessBuyingGroup + "]";
	}
	
	
	

}
