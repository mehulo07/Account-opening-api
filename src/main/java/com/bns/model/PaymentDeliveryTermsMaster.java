package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_deli_terms_master_tab" , schema = "ifsapp")
public class PaymentDeliveryTermsMaster implements Serializable{

	/**
	 * @author rathomoh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "deli_terms_id",nullable = false)
	private long deliveryTermsId;
	@Column(name = "deli_terms_name",nullable = false)
	private String deliveryTermsName;
	@Column(name = "active",nullable = false)
	private String active;
	
	public PaymentDeliveryTermsMaster() {
		super();
	}
	public PaymentDeliveryTermsMaster(long deliveryTermsId, String deliveryTermsName, String active) {
		super();
		this.deliveryTermsId = deliveryTermsId;
		this.deliveryTermsName = deliveryTermsName;
		this.active = active;
	}
	public long getDeliveryTermsId() {
		return deliveryTermsId;
	}
	public void setDeliveryTermsId(long deliveryTermsId) {
		this.deliveryTermsId = deliveryTermsId;
	}
	public String getDeliveryTermsName() {
		return deliveryTermsName;
	}
	public void setDeliveryTermsName(String deliveryTermsName) {
		this.deliveryTermsName = deliveryTermsName;
	}
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
