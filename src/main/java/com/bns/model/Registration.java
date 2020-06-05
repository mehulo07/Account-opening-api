package com.bns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="acc_opening_reg_info_tab" , schema = "ifsapp")
public class Registration implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1298211974861057016L;

	@Id
    @GeneratedValue(generator = "value")
    @SequenceGenerator(sequenceName = "acc_opening_mail_seq_tab", allocationSize = 1, name = "value")
	@Column(name="acc_opening_reg_info_id")
	private int accountOpeningRegInfoId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String surName;
	@Column(nullable = false)
	private String regPosition;
	@Column(nullable = false)
	private String regPharmacyName;
	@Column(nullable = false)
	private String regContactNoType;
	@Column(nullable = false)
	private String regContactNo;
	private String regWebSite;
	@Column(nullable = false)
	private String regEmailAddress;
	@Column(nullable = false)
	private String regPassword;
	@Column(nullable = false)
	private boolean regTermCondition;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_create_date")
	private Date regCreateDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_update_date")
	private Date regUpdateDate;
	
	
	
	

	public Registration() {
		
			}
	

	public Registration(int accountOpeningRegInfoId, String firstName, String surName, String regPosition,
			String regPharmacyName, String regContactNoType, String regContactNo, String regWebSite,
			String regEmailAddress, String regPassword, boolean regTermCondition, Date regCreateDate,
			Date regUpdateDate) {
		
		this.accountOpeningRegInfoId = accountOpeningRegInfoId;
		this.firstName = firstName;
		this.surName = surName;
		this.regPosition = regPosition;
		this.regPharmacyName = regPharmacyName;
		this.regContactNoType = regContactNoType;
		this.regContactNo = regContactNo;
		this.regWebSite = regWebSite;
		this.regEmailAddress = regEmailAddress;
		this.regPassword = regPassword;
		this.regTermCondition = regTermCondition;
		this.regCreateDate = regCreateDate;
		this.regUpdateDate = regUpdateDate;
	}


	public int getAccountOpeningRegInfoId() {
		return accountOpeningRegInfoId;
	}

	public void setAccountOpeningRegInfoId(int accountOpeningRegInfoId) {
		this.accountOpeningRegInfoId = accountOpeningRegInfoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getRegPosition() {
		return regPosition;
	}

	public void setRegPosition(String regPosition) {
		this.regPosition = regPosition;
	}

	public String getRegPharmacyName() {
		return regPharmacyName;
	}

	public void setRegPharmacyName(String regPharmacyName) {
		this.regPharmacyName = regPharmacyName;
	}

	public String getRegContactNoType() {
		return regContactNoType;
	}

	public void setRegContactNoType(String regContactNoType) {
		this.regContactNoType = regContactNoType;
	}

	public String getRegContactNo() {
		return regContactNo;
	}

	public void setRegContactNo(String regContactNo) {
		this.regContactNo = regContactNo;
	}

	public String getRegWebSite() {
		return regWebSite;
	}

	public void setRegWebSite(String regWebSite) {
		this.regWebSite = regWebSite;
	}

	public String getRegEmailAddress() {
		return regEmailAddress;
	}

	public void setRegEmailAddress(String regEmailAddress) {
		this.regEmailAddress = regEmailAddress;
	}

	public String getRegPassword() {
		return regPassword;
	}

	public void setRegPassword(String regPassword) {
		this.regPassword = regPassword;
	}

	public boolean isRegTermCondition() {
		return regTermCondition;
	}

	public void setRegTermCondition(boolean regTermCondition) {
		this.regTermCondition = regTermCondition;
	}

	public Date getRegCreateDate() {
		return regCreateDate;
	}

	public void setRegCreateDate(Date regCreateDate) {
		this.regCreateDate = regCreateDate;
	}

	public Date getRegUpdateDate() {
		return regUpdateDate;
	}

	public void setRegUpdateDate(Date regUpdateDate) {
		this.regUpdateDate = regUpdateDate;
	}


	@Override
	public String toString() {
		return "AccOpeningReg [accountOpeningRegInfoId=" + accountOpeningRegInfoId + ", firstName=" + firstName
				+ ", surName=" + surName + ", regPosition=" + regPosition + ", regPharmacyName=" + regPharmacyName
				+ ", regContactNoType=" + regContactNoType + ", regContactNo=" + regContactNo + ", regWebSite="
				+ regWebSite + ", regEmailAddress=" + regEmailAddress + ", regPassword=" + regPassword
				+ ", regTermCondition=" + regTermCondition + ", regCreateDate=" + regCreateDate + ", regUpdateDate="
				+ regUpdateDate + "]";
	}
	
	
}
