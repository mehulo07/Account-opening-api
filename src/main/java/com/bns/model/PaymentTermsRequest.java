package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_opening_payment_terms_req_tab")
public class PaymentTermsRequest implements Serializable{
	/**
	 * @author rathomoh
	 */
	private static final long serialVersionUID = 1L;
	private long requestId;
	private String requestName;
	private String active;
	
	public PaymentTermsRequest() {
		super();
	}
	public PaymentTermsRequest(long requestId, String requestName, String active) {
		super();
		this.requestId = requestId;
		this.requestName = requestName;
		this.active = active;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id",nullable = false)
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	@Column(name = "request_name",nullable = false)
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
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
		return "PaymentTermsRequest [requestId=" + requestId + ", requestName=" + requestName + ", active=" + active
				+ "]";
	}
	
	

}
