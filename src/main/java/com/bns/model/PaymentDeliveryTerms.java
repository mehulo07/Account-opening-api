package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_opening_payment_deli_terms_tab")
public class PaymentDeliveryTerms implements Serializable{

	/**
	 * @author rathomoh
	 */
	private static final long serialVersionUID = 1L;
	private long deliveryTermsId;
	private String deliveryTermsName;
	private String active;
	
	public PaymentDeliveryTerms() {
		super();
	}
	public PaymentDeliveryTerms(long deliveryTermsId, String deliveryTermsName, String active) {
		super();
		this.deliveryTermsId = deliveryTermsId;
		this.deliveryTermsName = deliveryTermsName;
		this.active = active;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deli_terms_id",nullable = false)
	public long getDeliveryTermsId() {
		return deliveryTermsId;
	}
	public void setDeliveryTermsId(long deliveryTermsId) {
		this.deliveryTermsId = deliveryTermsId;
	}
	@Column(name = "deli_terms_name",nullable = false)
	public String getDeliveryTermsName() {
		return deliveryTermsName;
	}
	public void setDeliveryTermsName(String deliveryTermsName) {
		this.deliveryTermsName = deliveryTermsName;
	}
	@Column(name = "active",nullable = false)
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "PaymentDeliveryTerms [deliveryTermsId=" + deliveryTermsId + ", deliveryTermsName=" + deliveryTermsName
				+ ", active=" + active + "]";
	}
	
	

}
