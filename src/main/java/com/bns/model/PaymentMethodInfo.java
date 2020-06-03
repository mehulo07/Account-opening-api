package com.bns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_methods_info_tab" , schema = "ifsapp")
public class PaymentMethodInfo implements Serializable{

	/**
	 * @author rathomoh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "method_info_Id",nullable = false)
	private long methodInfoId;
	@Column(name = "payment_method_id",nullable = false)
	private long paymentMethodId;
	@Column(name = "nhs_income")
	private String nHSIncome;
	@Column(name = "payment_term_id",nullable = false)
	private long paymentTermId;
	@Column(name = "credit_req")
	private String creditReq;
	@Column(name = "payment_deli_term_id",nullable = false)
	private long paymentDeliTermId;
	@Column(name = "comments")
	private String comments;
	@Column(name = "business_info_id",nullable = false)
	private long businessInfoId;
	@Column(name = "updated_by",nullable = false)
	private String updatedBy;
	@Column(name = "updated_on",nullable = false)
	private Date updatedOn;
	public PaymentMethodInfo() {
		super();
	}
	public PaymentMethodInfo(long methodInfoId, long paymentMethodId, String nHSIncome, long paymentTermId,
			String creditReq, long paymentDeliTermId, String comments, long businessInfoId, String updatedBy,
			Date updatedOn) {
		super();
		this.methodInfoId = methodInfoId;
		this.paymentMethodId = paymentMethodId;
		this.nHSIncome = nHSIncome;
		this.paymentTermId = paymentTermId;
		this.creditReq = creditReq;
		this.paymentDeliTermId = paymentDeliTermId;
		this.comments = comments;
		this.businessInfoId = businessInfoId;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}
	public long getMethodInfoId() {
		return methodInfoId;
	}
	public void setMethodInfoId(long methodInfoId) {
		this.methodInfoId = methodInfoId;
	}
	public long getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getnHSIncome() {
		return nHSIncome;
	}
	public void setnHSIncome(String nHSIncome) {
		this.nHSIncome = nHSIncome;
	}
	public long getPaymentTermId() {
		return paymentTermId;
	}
	public void setPaymentTermId(long paymentTermId) {
		this.paymentTermId = paymentTermId;
	}
	public String getCreditReq() {
		return creditReq;
	}
	public void setCreditReq(String creditReq) {
		this.creditReq = creditReq;
	}
	public long getPaymentDeliTermId() {
		return paymentDeliTermId;
	}
	public void setPaymentDeliTermId(long paymentDeliTermId) {
		this.paymentDeliTermId = paymentDeliTermId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public long getBusinessInfoId() {
		return businessInfoId;
	}
	public void setBusinessInfoId(long businessInfoId) {
		this.businessInfoId = businessInfoId;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	@Override
	public String toString() {
		return "PaymentMethodInfo [methodInfoId=" + methodInfoId + ", paymentMethodId=" + paymentMethodId
				+ ", nHSIncome=" + nHSIncome + ", paymentTermId=" + paymentTermId + ", creditReq=" + creditReq
				+ ", paymentDeliTermId=" + paymentDeliTermId + ", comments=" + comments + ", businessInfoId="
				+ businessInfoId + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
	}
}
