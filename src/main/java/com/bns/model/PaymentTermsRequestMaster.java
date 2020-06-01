package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_terms_req_master_tab")
public class PaymentTermsRequestMaster implements Serializable{
	/**
	 * @author rathomoh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id",nullable = false)
	private long requestId;
	@Column(name = "request_name",nullable = false)
	private String requestName;
	@Column(name = "active",nullable = false)
	private String active;
	
	public PaymentTermsRequestMaster() {
		super();
	}
	public PaymentTermsRequestMaster(long requestId, String requestName, String active) {
		super();
		this.requestId = requestId;
		this.requestName = requestName;
		this.active = active;
	}
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
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
