package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_opening_payment_methods_tab")
public class PaymentMethod implements Serializable{
	/**
	 * @author rathomoh
	 */
	private static final long serialVersionUID = 1L;
	private long methodId;
	private String methodName;
	private String active;
	public PaymentMethod(long methodId, String methodName, String active) {
		super();
		this.methodId = methodId;
		this.methodName = methodName;
		this.active = active;
	}
	public PaymentMethod() {
		super();
	}
	@Column(name = "active",nullable = false)
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "method_id",nullable = false)
	public long getMethodId() {
		return methodId;
	}
	public void setMethodId(long methodId) {
		this.methodId = methodId;
	}
	@Column(name = "method_name",nullable = false)
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	@Override
	public String toString() {
		return "PaymentMethod [methodId=" + methodId + ", methodName=" + methodName + ", active=" + active + "]";
	}
	
	

}
