package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_methods_master_tab")
public class PaymentMethodMaster implements Serializable{
	/**
	 * @author rathomoh
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "method_id",nullable = false)
	private long methodId;
	@Column(name = "method_name",nullable = false)
	private String methodName;
	@Column(name = "active",nullable = false)
	private String active;
	public PaymentMethodMaster() {
		super();
	}
	public PaymentMethodMaster(long methodId, String methodName, String active) {
		super();
		this.methodId = methodId;
		this.methodName = methodName;
		this.active = active;
	}
	public long getMethodId() {
		return methodId;
	}
	public void setMethodId(long methodId) {
		this.methodId = methodId;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "PaymentMethod [methodId=" + methodId + ", methodName=" + methodName + ", active=" + active + "]";
	}
	
	

}
